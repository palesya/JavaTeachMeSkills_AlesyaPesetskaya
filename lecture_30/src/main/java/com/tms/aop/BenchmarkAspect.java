package com.tms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BenchmarkAspect {

//    @Pointcut("execution(public * com.tms.service.impl.UserServiceImpl.*(..))")
//    public void benchServices() {
//    }
//
//    @Pointcut("execution(public * com.tms.service.impl.UserValidatorImpl.*(..))")
//    public void benchServiceValid() {
//    }

    @Pointcut("@annotation(com.tms.aop.BenchMark)")
    public void testBenchPoint(){

    }

//    @Before("benchServices() || benchServiceValid()")
//    public void startBench(JoinPoint joinPoint) {
//        System.out.println();
//        System.out.println("-----start bench-----");
//
//    }
//
//    @After("benchServices() || benchServiceValid()")
//    public void finishBench() {
//        System.out.println("-----finish bench-----");
//        System.out.println();
//    }

    @Around("testBenchPoint()")
    public void bench(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start bench");
        long start = System.currentTimeMillis();

        joinPoint.proceed();

        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
        System.out.println("finish bench");
    }

}
