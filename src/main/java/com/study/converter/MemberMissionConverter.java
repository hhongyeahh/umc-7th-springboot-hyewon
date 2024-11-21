package com.study.converter;

import com.study.domain.mapping.MemberMission;
import com.study.dto.response.MemberMissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO. MemberMissionStatusResultDto updateMemberMissionStatusDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionStatusResultDto.builder()
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .deadLine(memberMission.getMission().getDeadline())
                .reward(memberMission.getMission().getReward())
                .status(memberMission.getStatus())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO(Page<MemberMission> memberMissionList){
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreviewDTO).toList();
        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionList.getSize())
                .memberMissionList(memberMissionPreviewDTOList)
                .build();
    }
}
