package com.study.config;

import com.study.apiPayload.code.exception.PageHandlerResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final PageHandlerResolver pageHandlerResolver;

    public WebConfig(PageHandlerResolver pageHandlerResolver) {
        this.pageHandlerResolver = pageHandlerResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(pageHandlerResolver);
    }
}

