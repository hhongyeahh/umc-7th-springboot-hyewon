package com.study.controller;

import com.study.apiPayload.ApiResponse;
import com.study.converter.ReviewConverter;
import com.study.domain.Review;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.response.ReviewResponseDTO;
import com.study.service.ReviewService.ReviewCommandService;
import com.study.service.ReviewService.ReviewCommandServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews/")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO. addReviewToStoreResultDto> addReview(@RequestBody @Valid ReviewRequestDTO. addReviewToStoreDto request){
        Review review =reviewCommandService.addReviewToStore(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDto(review));
    }
}
