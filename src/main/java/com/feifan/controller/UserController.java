package com.feifan.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login/{username}")
    public String login(@PathVariable String username, HttpSession session){
        if(username != null){
            session.setAttribute("username",username);
            System.out.println("UserController.login-"+session.getId());
            return "ok";
        }
        return "username error";
    }

    @RequestMapping("/query")
    public String query(HttpSession session){
        System.out.println("UserController.query-"+session.getId());
        Object username = session.getAttribute("username");
        System.out.println("session saved-->"+username);
        return username.toString();
    }

}
