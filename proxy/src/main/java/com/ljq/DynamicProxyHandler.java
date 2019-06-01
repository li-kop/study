package com.ljq;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : LJQ
 * @date : 2019/5/20 16:55
 * 动态代理对象处理器
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理开始工作了");

        return method.invoke(proxyed,args);
    }
}
