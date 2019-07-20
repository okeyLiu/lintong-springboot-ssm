package com.feifan.security;

import com.feifan.security.JwtUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    /*
    http://localhost:9091/user/current?key=Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoidXNlciIsImlhdCI6MTU2MzU5Mjg5OCwiZXhwIjoxNTYzNTk0MDk4fQ.4B1Tp8GXoFHS82mgIoyy1lTdWpodB2qVtmtodXzgroo&param1=1&param2=2

    //带授权+Controller参数
    http://localhost:9091/user/current?key=Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoidXNlciIsImlhdCI6MTU2MzU5Mjg5OCwiZXhwIjoxNTYzNTk0MDk4fQ.4B1Tp8GXoFHS82mgIoyy1lTdWpodB2qVtmtodXzgroo&token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoidXNlciIsImlhdCI6MTU2MzU5Mjg5OCwiZXhwIjoxNTYzNTk0MDk4fQ.4B1Tp8GXoFHS82mgIoyy1lTdWpodB2qVtmtodXzgroo
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle");
        final String key = request.getParameter("key");
        /*String authHeader = request.getHeader("key");*/
            if (key == null || !key.startsWith("Bearer ")) {
            throw new ServletException("invalid Authorization header,请重新登陆");
        }
        //取得token
        String token = JwtUtil.getTokenByKey("Bearer ",key);
        try {
            JwtUtil.checkToken(token);
            System.out.println("prehandle --- end --" + token);
            return true;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
