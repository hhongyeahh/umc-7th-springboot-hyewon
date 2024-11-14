package com.study.apiPayload.code.exception.handler;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
