package com.study.service.StoreService;

import com.study.apiPayload.code.exception.handler.RegionHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import com.study.converter.StoreConverter;
import com.study.domain.Region;
import com.study.domain.Store;
import com.study.dto.request.StoreRequestDTO;
import com.study.repository.RegionRepository;
import com.study.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store addStoreToSpecificRegion(StoreRequestDTO.addStoreToSpecificRegionDto request) {
        Region region = regionRepository.findByName(request.getRegionName())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);
        return storeRepository.save(newStore);
    }
}
