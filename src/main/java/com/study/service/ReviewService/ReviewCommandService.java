package com.study.service.ReviewService;

import com.study.domain.Review;
import com.study.dto.request.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReviewToStore(ReviewRequestDTO.addReviewToStoreDto request);
}
