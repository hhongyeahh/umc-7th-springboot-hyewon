package com.study.repository.MissionRepository;

import com.study.domain.Mission;
import com.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
