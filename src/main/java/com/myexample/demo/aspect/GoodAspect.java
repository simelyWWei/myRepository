package com.myexample.demo.aspect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GoodAspect {

    @Pointcut("execution(* com.myexample.demo.service.GoodsService.*(..))")
    public void testAspect(){
    }

    @Around("testAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
      log.info("@Around testAspect() 执行{}方法",pjp.getSignature().getName());
      return pjp.proceed();
    }

    @Before("testAspect()")
    public void before(){
        // 在pjp.proceed之前执行
        log.info("before Around");
    }

    @After("testAspect()")
    public void after(JoinPoint pjp){
        log.info("after Around");
        log.info("@Around testAspect() GoodsService执行方法{}完毕",pjp.getSignature().getName());
    }
}
