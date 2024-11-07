package com.study.service.TempService;

import com.study.apiPayload.code.exception.handler.TempHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void CheckFlag(Integer flag) {
        if(flag ==1){
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
