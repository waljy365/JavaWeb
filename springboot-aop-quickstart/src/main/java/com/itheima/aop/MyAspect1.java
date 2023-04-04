package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : 王希辰
 * @date : 2023/4/4 21:35
 */
@Slf4j
@Component
@Aspect
public class MyAspect1 {
    // 抽取切面表达式
    // public表示其他类也可用这个表达式
    // private表示只有当前类可用这个表达式
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt() {
    }
    
    @Before("pt()")
    public void before() {
        log.info("before....");
    }

    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after() {
        log.info("after....");
    }

    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around....前");
        Object o = joinPoint.proceed();
        log.info("around....后");
        return o;
    }

    @AfterReturning("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void afterReturning() {
        log.info("afterReturning....");
    }

    @AfterThrowing("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void afterThrowing() {
        log.info("afterThrowing....");
    }
}
