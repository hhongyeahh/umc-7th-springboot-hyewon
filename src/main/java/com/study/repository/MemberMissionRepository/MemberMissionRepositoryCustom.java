package com.study.repository.MemberMissionRepository;

import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus missionStatus);

    MemberMission findByMemberAndMission(Member member, Mission mission);
}
