package com.study.dto.request;

import com.study.domain.Region;
import com.study.validation.annotation.ExistRegion;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class addStoreToSpecificRegionDto{
        @NotNull
        @ExistRegion
        String regionName;
        @NotNull
        String name;
        @NotNull
        String address;
        @NotNull
        Float score;
    }
}
