package com.study.apiPayload.code.exception.handler;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
