package com.study.apiPayload.code.exception;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomValidationException extends RuntimeException {
    private final BaseErrorCode code;

    // 에러 사유를 반환
    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    // HTTP 상태를 포함한 에러 사유 반환
    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
