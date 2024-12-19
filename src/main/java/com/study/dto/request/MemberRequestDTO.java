package com.study.dto.request;

import com.study.domain.Review;
import com.study.domain.enums.Role;
import com.study.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    @Setter //thymeleaf 에서 사용하기 위해 추가
    public static class JoinDto{
        @NotBlank
        String name;

        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;

        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min=5,max=12)
        String address;
        @Size(min=5,max=12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

}
