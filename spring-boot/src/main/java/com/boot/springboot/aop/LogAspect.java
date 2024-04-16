package com.boot.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Before(value = "within(com.boot.springboot.service.*)")
    public void createLog(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature() + " started.");
    }

    @After(value = "execution(public * com.boot.springboot.service.*.*(Long))")
    public void createdEndLog(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature() + " end.");
    }

    @AfterReturning(value = "within(com.boot.springboot.service.*)", returning = "returnValue")
    public void createAfterReturnLog(Object returnValue) {
        log.info("Return value: " + returnValue);
    }

    @AfterThrowing(value = "within(com.boot.springboot.service.*)", throwing = "throwingValue")
    public void createLogAfterThrowing(Throwable throwingValue) {
        log.error(String.valueOf(throwingValue));
    }

   /* @Around(value = "@annotation(com.boot.springboot.aop.TimeAOP)")
    public void logTime(ProceedingJoinPoint point) throws Throwable {
        LocalTime start = LocalTime.now();
        point.proceed();
        LocalTime finish = LocalTime.now();
        log.info("Method worked: " + String.valueOf(finish.getNano() - start.getNano()));
    }*/
}
