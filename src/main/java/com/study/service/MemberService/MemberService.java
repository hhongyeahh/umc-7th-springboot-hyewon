package com.study.service.MemberService;

import com.study.web.dto.MemberMyPageDto;

public interface MemberService {
    public MemberMyPageDto getMemberMyPage(Long memberId);
}
