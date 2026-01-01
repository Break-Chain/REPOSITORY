package com.bc.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
public class OrderAspect {
    @Pointcut("execution(public String com.bc.demo.controller.TestController.aop())")
    public void pt() {}
    @Around("pt()")
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("开始执行切面程序1");
        log.info("切入点名称{}" ,pjp.getSignature().getName());

        Object result=pjp.proceed();//执行原程序
        log.info("结束执行切面程序1");
        return result;
    }
    //@Before("pt()")
    public void before() {
        log.info("开始执行切面程序1");
    }
    //@After("pt()")
    public void after() {
        log.info("结束执行切面程序1");
    }
}
