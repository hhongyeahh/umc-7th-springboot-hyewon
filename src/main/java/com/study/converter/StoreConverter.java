package com.study.converter;

import com.study.domain.Region;
import com.study.domain.Store;
import com.study.dto.request.StoreRequestDTO;
import com.study.dto.response.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@RequiredArgsConstructor
public class StoreConverter {
    public static StoreResponseDTO.addStoreToSpecificRegionResultDto toAddStoreResultDto(Store store){
        return StoreResponseDTO. addStoreToSpecificRegionResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addStoreToSpecificRegionDto request, Region region) {
        return Store.builder()
                .address(request.getAddress())
                .region(region)
                .name(request.getName())
                .score(request.getScore())
                .build();
    }
}
