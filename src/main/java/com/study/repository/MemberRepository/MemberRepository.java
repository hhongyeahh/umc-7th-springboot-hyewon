package com.study.repository.MemberRepository;

import com.study.domain.Member;
import com.study.repository.MemberMissionRepository.MemberMissionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
