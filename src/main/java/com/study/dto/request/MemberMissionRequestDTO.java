package com.study.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {
    @Getter
    public static class MemberMissionStatusDto {
        @NotNull
        String status;
    }

}