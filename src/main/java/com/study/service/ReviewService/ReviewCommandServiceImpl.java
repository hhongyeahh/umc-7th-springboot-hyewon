package com.study.service.ReviewService;

import com.study.apiPayload.code.exception.handler.MemberHandler;
import com.study.apiPayload.code.exception.handler.StoreHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import com.study.converter.ReviewConverter;
import com.study.domain.Member;
import com.study.domain.Review;
import com.study.domain.Store;
import com.study.dto.request.ReviewRequestDTO;
import com.study.dto.request.StoreRequestDTO;
import com.study.repository.MemberRepository.MemberRepository;
import com.study.repository.ReviewRepository.ReviewRepository;
import com.study.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.study.domain.QMember.member;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    @Override
    public Review addReviewToStore(ReviewRequestDTO.addReviewToStoreDto request) {
        Store store = storeRepository.findByName(request.getStoreName())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Member member = memberRepository.findByName(request.getMemberName())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));


        Review newReview = ReviewConverter.toReview(request, store, member);
        return reviewRepository.save(newReview);
    }
}
