package com.feifan.config;

import com.feifan.interceptor.HahaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
拦截器专用配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean// <bean id="getHahaInterceptor" class="com.feifan.interceptor.HahaInterceptor"/>
    public HahaInterceptor getHahaInterceptor() {
        return new HahaInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
// addPathPatterns 用于添加拦截规则
// excludePathPatterns 用户排除拦截
        //registry.addInterceptor(getHahaInterceptor()).addPathPatterns("/*".excludePathPatterns("/static/**", "/public/**", "/resources/**");
    }

}