package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : 王希辰
 * @date : 2023/4/4 20:56
 */
@Slf4j
@Component
@Aspect// 该注解是把此类声明为一个切面类
public class TimeAspect {
    @Around("com.itheima.aop.MyAspect1.pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.记录开始时间
        long begin = System.currentTimeMillis();
        // 2.调用原始方法运行
        Object result = joinPoint.proceed();
        // 3.记录结束时间,计算方法耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",end-begin);
        return result;

    }
}
