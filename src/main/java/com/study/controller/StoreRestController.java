package com.study.controller;

import com.study.apiPayload.ApiResponse;
import com.study.converter.ReviewConverter;
import com.study.converter.StoreConverter;
import com.study.domain.Review;
import com.study.domain.Store;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.request.StoreRequestDTO;
import com.study.dto.response.ReviewResponseDTO;
import com.study.dto.response.StoreResponseDTO;
import com.study.service.ReviewService.ReviewCommandService;
import com.study.service.StoreService.StoreCommandService;
import com.study.service.StoreService.StoreQueryService;
import com.study.validation.annotation.ExistStore;
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
@RequestMapping("/stores/")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO. addStoreToSpecificRegionResultDto> addStore(@RequestBody @Valid StoreRequestDTO.addStoreToSpecificRegionDto request){
        Store store = storeCommandService.addStoreToSpecificRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDto(store));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }

//    @GetMapping("/")
//    @Operation(summary = "가게 리스트 조회 API", description = "전체 가게의 리스트를 조회하는 API")
//
//    @GetMapping("/{storeId}")
//    @Operation(summary = "가게 단건 조회 API")

}
