package com.feifan.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect//定义一个切面
@Component//被Spring管理
public class TimeAspect {

    @Pointcut("bean(bookServiceImpl)")
    private void pointCut(){}//切点

    @Around("pointCut()")//环绕通知
    public Object costTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println("\n======>\n测试["+name+"]时间开始");
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("测试["+name+"]时间结束，耗时："+ time+"纳秒");
        System.out.println("<======\n");
        return proceed;//返回值
    }

}
