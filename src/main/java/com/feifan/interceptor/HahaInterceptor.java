package com.feifan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HahaInterceptor implements HandlerInterceptor {

    @Override//在Controller执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("HahaInterceptor.preHandle");
        return true;
    }

    @Override//执行Controller
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("HahaInterceptor.postHandle");

    }

    @Override//执行完成
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("HahaInterceptor.afterCompletion");
    }
}
