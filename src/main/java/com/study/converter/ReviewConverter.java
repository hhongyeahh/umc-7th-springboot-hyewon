package com.study.converter;

import com.study.domain.Member;
import com.study.domain.Review;
import com.study.domain.Store;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.response.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).toList();
        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
