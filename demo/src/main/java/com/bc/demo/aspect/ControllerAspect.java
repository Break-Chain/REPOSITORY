package com.bc.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect//声明一个切面类 通知方法+切入点=切面
@Slf4j
@Component
@Order(2)
//可以被增强的方法都是接入点
//实际被增强的方法是切入点
//被应用的对象就是目标对象
public class ControllerAspect {
    @Pointcut("execution(* com.bc.demo.controller.*.aop(..))")//定义公共切入点
    public void pt() {}
    //环绕通知方法
   // @Around("execution(* com.bc.demo.controller.*.aop(..))")//指定接入点
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("开始执行切面程序2");
        Object result=pjp.proceed();//执行原程序
        log.info("结束执行切面程序2");
        return result;
    }
    @Before("pt()")
    public void before() {
        log.info("开始执行切面程序2");
    }
    @After("pt()")
    public void after() {
        log.info("结束执行切面程序2");
    }
}
