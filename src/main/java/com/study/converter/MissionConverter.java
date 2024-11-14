package com.study.converter;

import com.study.domain.Mission;
import com.study.domain.Store;
import com.study.dto.request.MissionRequestDTO;
import com.study.dto.response.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.addMissionToStoreResultDto toAddMission(Mission mission){
        return MissionResponseDTO.addMissionToStoreResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addMissionToStoreDto request,Store store){
        return Mission.builder()
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .store(store)
                .missionSpec(request.getMissionSpec())
                .build();

    }
}
