package com.study.service.MemberService;

import com.study.domain.Review;
import com.study.dto.MemberMyPageDto;
import org.springframework.data.domain.Page;

public interface MemberQueryService {
    public MemberMyPageDto getMemberMyPage(Long memberId);

    Page<Review> getReviewList(Long memberId, Integer page);
    Boolean existsById(Long memberId);
}
