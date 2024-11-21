package com.study.service.MemberMissionService;

import com.study.apiPayload.code.exception.handler.MemberHandler;
import com.study.apiPayload.code.exception.handler.MissionHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;
import com.study.dto.request.MemberMissionRequestDTO;
import com.study.repository.MemberMissionRepository.MemberMissionRepository;
import com.study.repository.MemberRepository.MemberRepository;
import com.study.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    @Transactional
    public MemberMission updateMemberMissionStatus(
                                                   Long memberId,
                                                   Long missionId) {
        // Member와 Mission 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 기존 MemberMission 조회 및 상태 업데이트
        MemberMission memberMission = memberMissionRepository.findByMemberAndMission(member, mission);
        if(memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new MissionHandler(ErrorStatus.MISSION_STATUS_COMPLETE);
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
        return memberMissionRepository.save(memberMission);
    }
}
