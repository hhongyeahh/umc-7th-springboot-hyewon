package com.study.validation.validator;

import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;
import com.study.validation.annotation.CheckMissionStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionStatusCheckValidator implements ConstraintValidator<CheckMissionStatus, MemberMission> {

    @Override
    public boolean isValid(MemberMission memberMission, ConstraintValidatorContext context) {
        // 상태가 CHALLENGING인지 확인
        if (memberMission != null && memberMission.getStatus() == MissionStatus.CHALLENGING) {
            return false;  // 도전 중이면 false 반환
        }
        return true;
    }
}
