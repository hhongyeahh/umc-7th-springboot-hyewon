package com.study.converter;

import com.study.domain.Member;
import com.study.domain.enums.Gender;
import com.study.dto.request.MemberRequestDTO;
import com.study.dto.response.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class MemberConverter {

    //Member 객체를 MemberResponseDTO. JoinResultDto 형식으로 변환하는 역할 수행
    public static MemberResponseDTO.JoinResultDto toJoinResultDto(Member member){
        return MemberResponseDTO. JoinResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };
        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthDay(request.getBirthDay())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
