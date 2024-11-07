package com.study.service.MissionService;

import com.study.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);

    List<Mission> findMissionByRegion(String regionName);
}
