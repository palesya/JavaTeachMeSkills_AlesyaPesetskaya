package com.tms.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggableAspect {

//    @Pointcut("@annotation(com.tms.aop.Loggable)")
//    public void loggablePointCut() {
//    }

    @Around("@annotation(Loggable)")
    public void bench(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println();
        System.out.println("----------Time of method '" + methodName+"' start:");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("----------yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println();

        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("----------Total time of method '" + methodName + "' working " + (end - start) + " millis");
        System.out.println();
    }

}
