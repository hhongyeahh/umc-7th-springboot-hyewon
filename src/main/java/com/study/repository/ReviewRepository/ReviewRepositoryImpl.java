package com.study.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;
import com.study.domain.QMember;
import com.study.domain.QReview;
import com.study.domain.QStore;
import com.study.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPQLQueryFactory jpqlQueryFactory;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;
    private final QMember member = QMember.member;

    @Override
    public Page<Review> dynamicQueryWithBooleanBuilder(String storeName, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (storeName != null) {
            predicate.and(review.store.name.eq(storeName));
        }

        // Fetch Join으로 리뷰와 스토어, 멤버를 함께 로딩
        List<Review> reviews = jpqlQueryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()    // 스토어를 Fetch Join
                .join(review.member, member).fetchJoin()  // 멤버를 Fetch Join
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 전체 데이터 수 조회 (이 때는 Fetch Join을 사용하지 않아도 됨)
        long total = jpqlQueryFactory
                .selectFrom(review)
                .join(review.store, store)
                .where(predicate)
                .fetchCount();

        return new PageImpl<>(reviews, pageable, total);
    }
}