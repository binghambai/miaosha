package com.binghambai.mallopen.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/")
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/goods/getAll")
                .excludePathPatterns("/api/customer/create")
                .excludePathPatterns("/api/token/verify")
                .excludePathPatterns("/error");
    }
}
