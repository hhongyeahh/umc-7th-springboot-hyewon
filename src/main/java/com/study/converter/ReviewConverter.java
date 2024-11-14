package com.study.converter;

import com.study.domain.Member;
import com.study.domain.Review;
import com.study.domain.Store;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.response.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.addReviewToStoreResultDto toReviewResultDto(Review review){
        return ReviewResponseDTO.addReviewToStoreResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO. addReviewToStoreDto request, Store store, Member member){
        return Review.builder()
                .body(request.getBody())
                .member(member)
                .score(request.getScore())
                .store(store)
                .build();
    }
}
