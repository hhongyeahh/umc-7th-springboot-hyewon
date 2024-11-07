package com.study.apiPayload.code.exception.handler;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
