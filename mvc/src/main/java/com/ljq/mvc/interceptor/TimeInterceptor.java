package com.ljq.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : LJQ
 * @date : 2019/6/7 14:09
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle");

       // System.out.println(((HandlerMethod)handler).getBean().getClass().getName());

       // System.out.println(((HandlerMethod)handler).getMethod().getClass().getName());

        request.setAttribute("startTime",System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
        long start= (long) request.getAttribute("startTime");

        System.out.println("TimeInterceptor耗时："+(System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long start= (long) request.getAttribute("startTime");

        System.out.println("TimeInterceptor耗时："+(System.currentTimeMillis()-start));

        System.out.println("ex is:"+ex);
    }


}
