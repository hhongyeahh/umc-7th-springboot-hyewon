package com.study.repository.ReviewRepository;


import com.study.domain.Review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {
    Page<Review> dynamicQueryWithBooleanBuilder(String storeName, Pageable pageable);
}

