package com.ljq.mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author : LJQ
 * @date : 2019/6/7 14:31
 */
@Aspect
@Component
public class TimeAspect {

@Around("execution(* com.ljq.mvc.web.controller.UserController.*(..))")
public Object  handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

    System.out.println("TimeAspect start");
    Object[] args = pjp.getArgs();
    Arrays.stream(args).forEach(System.out::println);
    long start = System.currentTimeMillis();
    Object o = pjp.proceed();
    System.out.println("TimeAspect 耗时:"+(System.currentTimeMillis()-start));
    System.out.println("TimeAspect end");

    return o;
}

}
