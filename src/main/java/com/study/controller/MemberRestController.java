package com.study.controller;

import com.study.apiPayload.ApiResponse;
import com.study.converter.MemberConverter;
import com.study.converter.MemberMissionConverter;
import com.study.converter.ReviewConverter;
import com.study.domain.Member;
import com.study.domain.Review;
import com.study.domain.mapping.MemberMission;
import com.study.dto.request.MemberMissionRequestDTO;
import com.study.dto.request.MemberRequestDTO;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.response.MemberMissionResponseDTO;
import com.study.dto.response.MemberResponseDTO;
import com.study.dto.response.ReviewResponseDTO;
import com.study.service.MemberMissionService.MemberMissionCommandService;
import com.study.service.MemberMissionService.MemberMissionQueryService;
import com.study.service.MemberService.MemberCommandService;
import com.study.service.MemberService.MemberQueryService;
import com.study.service.ReviewService.ReviewCommandService;
import com.study.validation.annotation.ExistMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberMissionCommandService memberMissionCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MemberMissionQueryService memberMissionQueryService;
    @PostMapping("/")
    @Operation(summary = "회원가입 API")
    public ApiResponse<MemberResponseDTO.JoinResultDto> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDto(member));
    }
    @PostMapping("/{memberId}/missions/{missionId}/")
    @Operation(summary = "멤버 미션 상태 수정 API", description = "멤버와 미션의 ID를 둘 다 받아서, 임의로 미션의 상태를 수정할 수 있음")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionStatusResultDto> updateMemberMissionStatus(
            @RequestBody @Valid MemberMissionRequestDTO.MemberMissionStatusDto request,
            @PathVariable Long memberId,
            @PathVariable Long missionId) {

        MemberMission memberMission = memberMissionCommandService.updateMemberMissionStatus(request, memberId, missionId);
        MemberMissionResponseDTO.MemberMissionStatusResultDto responseDto = MemberMissionResponseDTO.MemberMissionStatusResultDto.builder()
                .updatedAt(memberMission.getUpdatedAt())
                .build();

        return ApiResponse.onSuccess(responseDto);
    }



    @GetMapping("/{memberId}/missions")
    @Operation(summary = "진행 중인 리스트 조회 API", description = "내가 진행중인 미션 들을 조회하는 API이며, 페이징을 포함. query string으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "스프링 시큐리티 적용 전이라 path-variable 로 받아옴")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewListDTO> getChallengingMissionList(@ExistMember @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberMissionQueryService.getChallengingMissionList(memberId, page);

        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreviewListDTO(memberMissionList));
    }

    @PostMapping("/reviews")
    @Operation(summary = "리뷰 추가 API")
    public ApiResponse<ReviewResponseDTO. addReviewToStoreResultDto> addReview(@RequestBody @Valid ReviewRequestDTO. addReviewToStoreDto request){
        Review review =reviewCommandService.addReviewToStore(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDto(review));
    }


    @PatchMapping("/{memberId}/reviews")
    @Operation(summary = "리뷰 리스트 조회 API",
            description = "내가 작성한 리뷰들을 조회하는 API이며, 페이징을 포함. query string으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "스프링 시큐리티 적용 전이라 path-variable 로 받아옴")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistMember @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }

}