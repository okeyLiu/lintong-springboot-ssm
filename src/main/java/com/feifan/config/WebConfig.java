package com.feifan.config;

import com.feifan.security.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
拦截器专用配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public JwtInterceptor getJwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
         多个拦截器组成一个拦截器链
        */
        registry.addInterceptor(getJwtInterceptor())
            .excludePathPatterns("/user/login");//放开登录

    }

}