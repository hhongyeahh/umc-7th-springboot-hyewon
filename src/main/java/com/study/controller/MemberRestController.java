package com.study.controller;

import com.study.apiPayload.ApiResponse;
import com.study.converter.MemberConverter;
import com.study.domain.Member;
import com.study.domain.mapping.MemberMission;
import com.study.dto.request.MemberMissionRequestDTO;
import com.study.dto.request.MemberRequestDTO;
import com.study.dto.response.MemberMissionResponseDTO;
import com.study.dto.response.MemberResponseDTO;
import com.study.service.MemberMissionService.MemberMissionCommandService;
import com.study.service.MemberService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDto> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDto(member));
    }
    @PostMapping("/missions/{memberId}/{missionId}/")
    public ApiResponse<MemberMissionResponseDTO.updateMemberMissionStatusResultDto> updateMemberMissionStatus(
            @RequestBody @Valid MemberMissionRequestDTO.updateMemberMissionStatusDto request,
            @PathVariable Long memberId,
            @PathVariable Long missionId) {

        MemberMission memberMission = memberMissionCommandService.updateMemberMissionStatus(request, memberId, missionId);
        MemberMissionResponseDTO.updateMemberMissionStatusResultDto responseDto = MemberMissionResponseDTO.updateMemberMissionStatusResultDto.builder()
                .updatedAt(memberMission.getUpdatedAt())
                .build();

        return ApiResponse.onSuccess(responseDto);
    }
}