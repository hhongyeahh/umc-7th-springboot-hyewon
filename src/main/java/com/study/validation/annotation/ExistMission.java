package com.study.validation.annotation;

import com.study.validation.validator.MissionExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import javax.swing.text.Element;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "해당 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}