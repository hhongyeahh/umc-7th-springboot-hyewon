package com.study.repository.MemberRepository;

import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.mapping.MemberMission;
import com.study.repository.MemberMissionRepository.MemberMissionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByName(String memberName);
    Optional<Member> findByEmail(String email);
}
