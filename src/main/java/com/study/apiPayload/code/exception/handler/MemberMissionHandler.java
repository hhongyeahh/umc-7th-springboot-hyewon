package com.study.apiPayload.code.exception.handler;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode code) {
        super(code);
    }
}
