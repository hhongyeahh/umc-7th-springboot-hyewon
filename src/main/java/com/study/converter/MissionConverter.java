package com.study.converter;

import com.study.domain.Mission;
import com.study.domain.Store;
import com.study.dto.request.MissionRequestDTO;
import com.study.dto.response.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

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

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).toList();
        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
