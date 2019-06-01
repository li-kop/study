package com.ljq;

import java.lang.reflect.Proxy;

/**
 * @author : LJQ
 * @date : 2019/5/20 17:19
 */
public class Test {

    public static void main(String[] args) {

        RealObject realObject=new RealObject();

        Intetface01 proxy= (Intetface01) Proxy.newProxyInstance(Intetface01.class.getClassLoader(),new Class[]{Intetface01.class},new DynamicProxyHandler(realObject));

        proxy.doSomething();

        proxy.doSomethingElse();
    }
}
