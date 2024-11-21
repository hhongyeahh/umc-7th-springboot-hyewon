package com.study.service.MemberService;

import com.study.domain.Member;
import com.study.domain.Review;
import com.study.repository.MemberRepository.MemberRepository;
import com.study.dto.MemberMyPageDto;
import com.study.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public MemberMyPageDto getMemberMyPage(Long memberId) {
        MemberMyPageDto memberMyPageDto = memberRepository.findMemberMyPageById(memberId);

        if (memberMyPageDto != null) {
            // MemberMyPageDto 객체의 필드 값을 출력
            memberMyPageDto.print();
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }

        return memberMyPageDto;
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> MemberPage =reviewRepository.findAllByMember(member, PageRequest.of(page,10));
        return MemberPage;
    }

    @Override
    public Boolean existsById(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}