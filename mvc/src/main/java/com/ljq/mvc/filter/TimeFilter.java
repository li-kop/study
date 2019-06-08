package com.ljq.mvc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : LJQ
 * @date : 2019/6/7 13:42
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter start");
        long start=System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("TimeFilter耗时："+(System.currentTimeMillis()-start));
        System.out.println("TimeFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy");
    }
}
