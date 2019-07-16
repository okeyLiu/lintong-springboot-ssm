package com.feifan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
这是IndexController的作用是测试jsp的支持和路径是否ok
SpringBoot是可以跑JSP的
写的什么注释，还好意思发
来，开骂！！who pa who !!!
*/
@Controller
public class IndexController {
    @RequestMapping("/index")
    //知道这是什么吗
    public String index() {
        return "index";
    }
}
