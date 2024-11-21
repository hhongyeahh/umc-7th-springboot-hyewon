package com.study.service.ReviewService;

import com.study.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewQueryService {
    public Page<Review> findReviewsByStoreName(String storeName, Integer page, Integer size);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
