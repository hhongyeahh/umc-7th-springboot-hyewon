package com.study.service.MissionService;

import com.study.domain.Mission;
import com.study.domain.Store;
import com.study.repository.MissionRepository.MissionRepository;
import com.study.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Boolean existsById(Long missionId) {
        return missionRepository.existsById(missionId);
    }

    @Override
    public List<Mission> findMissionByRegion(String regionName) {
        List<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(regionName);
        filteredMissions.forEach(mission -> System.out.println("Mission: "+ mission));
        return filteredMissions;
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) {
        log.info("Page passed to repository: {}", page); // 디버깅 로그


        Store store = storeRepository.findById(StoreId).get();
        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page,10));
        return missionPage;
    }

}
