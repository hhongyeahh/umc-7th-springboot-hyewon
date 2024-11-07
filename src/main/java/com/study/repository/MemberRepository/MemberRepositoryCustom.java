package com.study.repository.MemberRepository;

import com.study.domain.Member;
import com.study.web.dto.MemberMyPageDto;

import java.util.List;

public interface MemberRepositoryCustom {
    MemberMyPageDto findMemberMyPageById(Long memberId);
}