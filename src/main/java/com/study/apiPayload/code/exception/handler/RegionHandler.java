package com.study.apiPayload.code.exception.handler;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
