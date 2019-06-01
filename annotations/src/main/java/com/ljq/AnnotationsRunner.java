package com.ljq;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author : LJQ
 * @date : 2019/6/1 9:38
 */
public class AnnotationsRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("执行自定义注解开始时间：" + new Date());

        Class clazz = Test.class;

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {

            boolean flag = method.isAnnotationPresent(demo01.class);

            if(flag){

                method.invoke(clazz.newInstance(),null);
            }
        }
    }

}
