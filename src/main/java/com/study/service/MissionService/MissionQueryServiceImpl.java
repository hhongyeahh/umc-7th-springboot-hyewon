package com.study.service.MissionService;

import com.study.domain.Mission;
import com.study.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionByRegion(String regionName) {
        List<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(regionName);
        filteredMissions.forEach(mission -> System.out.println("Mission: "+ mission));
        return filteredMissions;
    }
}
