package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PerformanceAspect {
    private static final Logger logger = LogManager.getLogManager().getLogger("PerformanceAspect");

    @Around("execution(* com.example.demo.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
