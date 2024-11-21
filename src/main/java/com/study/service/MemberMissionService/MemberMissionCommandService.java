package com.study.service.MemberMissionService;

import com.study.domain.mapping.MemberMission;
import com.study.dto.request.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission updateMemberMissionStatus(Long memberId, Long missionId);
}
