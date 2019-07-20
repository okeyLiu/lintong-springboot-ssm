package com.feifan.controller;

import com.feifan.common.Result;
import com.feifan.entity.User;
import com.feifan.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @func 测试时先用死的用户名密码，请求使用JSON格式数据
     * <p>
     * 加@RequestBody
     * data: JSON.stringify({
     *          "username": "admin",
     *          "password": "1234"
     *      }),
     * 不加@RequestBody
     * ?username=admin&password=1234
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) throws ServletException {
        if (!"admin".equals(user.getUsername())) {
            throw new ServletException("no such user");
        }
        if (!"1234".equals(user.getPassword())) {
            throw new ServletException("wrong password");
        }
        String token = JwtUtil.getToken(user.getUsername());
        System.out.println(token);
        return new Result(token);
    }

    /**
     * @func 用于客户端检查token是否合法
     */
    @PostMapping("/checkToken")
    public Result checkToken(String token) {
        return new Result(JwtUtil.isTokenOk(token));
    }

    /**
     * 返回当前的token中的用户名
     *
     * @param token
     * @return
     */
    @GetMapping("/current")
    public Result getUser(String token) {
        return new Result(JwtUtil.getUsername(token));
    }

}
