package com.study.service.MissionService;

import com.study.domain.Mission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
    Boolean existsById(Long missionId);

    List<Mission> findMissionByRegion(String regionName);
    Page<Mission> getMissionList(Long StoreId, Integer page);
}
