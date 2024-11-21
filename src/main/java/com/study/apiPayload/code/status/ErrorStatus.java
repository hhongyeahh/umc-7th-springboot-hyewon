package com.study.apiPayload.code.status;

import com.study.apiPayload.code.BaseErrorCode;
import com.study.apiPayload.code.ErrorReasonDTO;
import com.study.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON000","서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN,"COMMON403","금지된 요청입니다."),

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEMBER4001","사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST,"MEMBER4002","닉네임은 필수입니다."),

    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND,"ARTICLE4001","게시글이 없습니다."),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"FOOD CATEGORY4001", "음식 카테고리가 없습니다."),
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION 4001","해당 지역이 없습니다."),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE 4001","해당 식당이 없습니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION 4001","해당 미션이 없습니다."),
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MEMBER MISSION 4001", "해당 멤버 미션이 없습니다."),
    MISSION_STATUS_COMPLETE(HttpStatus.BAD_REQUEST,"MEMBER MISSION 4002", "미션이 진행 완료 상태 입니다."),

    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE 4001", "잘못된 페이지 번호 입니다."),


    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001", "이거는 테스트");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
