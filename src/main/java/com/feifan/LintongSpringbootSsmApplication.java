package com.feifan;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.feifan.dao")
@EnableAspectJAutoProxy
public class LintongSpringbootSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LintongSpringbootSsmApplication.class, args);
    }

}
