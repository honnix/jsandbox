package com.honnix.jsandbox.aspectj.spring;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WorldAspect {
    @Around("execution(* say(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("method: " + joinPoint.getSignature().getName());
        System.out.println("arguments: " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("before");
        joinPoint.proceed();
        System.out.println("after");
    }
}
