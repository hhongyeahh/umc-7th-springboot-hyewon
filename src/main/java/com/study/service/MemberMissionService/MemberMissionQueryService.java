package com.study.service.MemberMissionService;

import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberMissionQueryService {
    Optional<MemberMission> findMemberMissions(Long id);

    List<MemberMission> findMemberMissionsByNameAndMissionStatus(Long memberId, MissionStatus missionStatus);

    Page<MemberMission> getChallengingMissionList(Long memberId, Integer page);

    Page<MemberMission> findAndUpdateChallengingMissions(Long memberId, Integer page);
}
