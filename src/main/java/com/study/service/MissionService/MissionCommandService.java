package com.study.service.MissionService;

import com.study.domain.Mission;
import com.study.dto.request.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMissionToStore(MissionRequestDTO.addMissionToStoreDto request);

}
