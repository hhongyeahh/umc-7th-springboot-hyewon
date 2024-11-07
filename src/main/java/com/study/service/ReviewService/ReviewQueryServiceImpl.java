package com.study.service.ReviewService;

import com.study.domain.Review;
import com.study.repository.ReviewRepository.ReviewRepository;
import com.study.repository.ReviewRepository.ReviewRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> findReviewsByStoreName(String storeName, Integer page, Integer size) {
        // 기본값 설정: 페이지 번호 0, 페이지 크기 10
        int defaultPage = (page != null) ? page : 0;
        int defaultSize = (size != null) ? size : 10;

        Pageable pageable = PageRequest.of(defaultPage, defaultSize, Sort.by("createdAt").descending()); // 생성 날짜 기준 내림차순 정렬
        Page<Review> reviewsPage = reviewRepository.dynamicQueryWithBooleanBuilder(storeName, pageable);

        // 디버깅 목적으로 리뷰 내용을 출력
        reviewsPage.getContent().forEach(System.out::println);

        return reviewsPage;
    }
}