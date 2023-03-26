package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceLoggerAspect {

    private Logger logger = Logger.getLogger("performance.logger");

    public Object testPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = 0;
        try {

             startTime = System.currentTimeMillis();
             return joinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            logger.info(joinPoint.getSignature().getName() + "% method take times:: %d"
            + (endTime - startTime ) + " milliseconds.");

        }
    }
}
