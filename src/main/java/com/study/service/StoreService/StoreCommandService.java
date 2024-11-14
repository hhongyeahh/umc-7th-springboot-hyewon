package com.study.service.StoreService;

import com.study.domain.Store;
import com.study.dto.request.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStoreToSpecificRegion(StoreRequestDTO.addStoreToSpecificRegionDto request);

}
