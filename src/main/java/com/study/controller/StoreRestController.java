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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO. addStoreToSpecificRegionResultDto> addStore(@RequestBody @Valid StoreRequestDTO.addStoreToSpecificRegionDto request){
        Store store = storeCommandService.addStoreToSpecificRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDto(store));
    }

    private final ReviewCommandService reviewCommandService;

    // PathVariable 가계를 통해 리뷰 리스트 조회하는 것 작성 필요
//    @PostMapping("/{store_id}/reviews")
//    public ApiResponse<ReviewResponseDTO. addReviewToStoreResultDto> addReview(@RequestBody @Valid ReviewRequestDTO. addReviewToStoreDto request){
//        Review review =reviewCommandService.addReviewToStore(request);
//        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDto(review));
//    }

}
