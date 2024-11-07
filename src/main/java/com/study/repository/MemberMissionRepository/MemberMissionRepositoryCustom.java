package com.study.repository.MemberMissionRepository;

import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus missionStatus);
}
