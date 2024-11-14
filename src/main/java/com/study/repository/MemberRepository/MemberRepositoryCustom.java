package com.study.repository.MemberRepository;

import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.mapping.MemberMission;
import com.study.dto.MemberMyPageDto;

public interface MemberRepositoryCustom {
    MemberMyPageDto findMemberMyPageById(Long memberId);


}