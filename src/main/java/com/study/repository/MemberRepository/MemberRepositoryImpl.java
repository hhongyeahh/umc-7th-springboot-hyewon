package com.study.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.domain.Member;
import com.study.domain.QMember;
import com.study.domain.QReview;
import com.study.domain.Review;
import com.study.web.dto.MemberMyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;
    private final QReview review = QReview.review;

    @Override
    public MemberMyPageDto findMemberMyPageById(Long memberId) {
        Member memberData = queryFactory
                .selectFrom(member)
                .leftJoin(member.reviewList, review).fetchJoin()  // 리뷰 목록을 함께 조회
                .where(member.id.eq(memberId))
                .fetchOne();

        List<Review> reviews = queryFactory
                .selectFrom(review)
                .where(review.member.id.eq(memberId))
                .fetch();

        if (memberData != null) {
            return new MemberMyPageDto(
                    memberData.getId(),
                    memberData.getEmail(),
                    memberData.getPoint(),
                    reviews
            );
        }
        return null;
    }
}
