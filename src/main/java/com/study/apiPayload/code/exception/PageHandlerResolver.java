package com.study.apiPayload.code.exception;

import com.study.apiPayload.code.status.ErrorStatus;
import com.study.validation.annotation.CheckPage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageHandlerResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // @CheckPage 어노테이션이 붙어 있는 Integer 타입 파라미터를 처리
        return parameter.getParameterAnnotation(CheckPage.class) != null &&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Integer page;
        String pageParam = webRequest.getParameter("page");

        try {
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            } else {
                page = 0; // 기본값 설정
            }
        } catch (NumberFormatException ex) {
            throw new CustomValidationException(ErrorStatus.INVALID_PAGE);
        }

        if (page < 0) {
            throw new CustomValidationException(ErrorStatus.INVALID_PAGE);
        }

        // page 값을 -1로 조정
        return Math.max(0, page - 1);
    }
}
