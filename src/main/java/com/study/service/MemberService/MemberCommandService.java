package com.study.service.MemberService;

import com.study.domain.Member;
import com.study.dto.request.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
