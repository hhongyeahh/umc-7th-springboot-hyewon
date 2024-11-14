package com.study.service.MissionService;

import com.study.apiPayload.code.exception.handler.StoreHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import com.study.converter.MissionConverter;
import com.study.domain.Mission;
import com.study.domain.Store;
import com.study.dto.request.MissionRequestDTO;
import com.study.repository.MissionRepository.MissionRepository;
import com.study.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    public Mission addMissionToStore(MissionRequestDTO.addMissionToStoreDto request){
        Store store = storeRepository.findByName(request.getStoreName())
                .orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);
        return missionRepository.save(newMission);
    }
}
