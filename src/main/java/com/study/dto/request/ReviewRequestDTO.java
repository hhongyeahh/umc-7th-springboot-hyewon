package com.study.dto.request;

import com.study.domain.Member;
import com.study.domain.Store;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class addReviewToStoreDto{
        @NotNull
        String memberName;
        @NotNull
        String storeName;
        @NotNull
        String body;
        @NotNull
        Float score;
    }
}
