package com.study.dto.request;

import com.study.domain.Store;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class addMissionToStoreDto{
        @NotNull
        String storeName;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        String missionSpec;
    }
}
