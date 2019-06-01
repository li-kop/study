package com.ljq;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : LJQ
 * @date : 2019/5/20 12:54
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.ljq.ShareData");

        Field[] declaredFields = clazz.getDeclaredFields();

        //Arrays.stream(declaredFields).forEach(f -> System.out.println(f));

        Field name = clazz.getDeclaredField("name");

        ShareData shareData=new ShareData();
        //暴力反射，修改访问权限
        name.setAccessible(true);

        name.set(shareData,"zs");

        System.out.println(shareData);

        Method[] declaredMethods = clazz.getDeclaredMethods();


        Arrays.stream(declaredFields).forEach(f -> System.out.println(f));


    }


}


class ShareData {

    private String name;

    private Integer age;

    public String desc;

    public static void publicMethod(){

        System.out.println("publicMethod-----");
    }
    private static void privateMethod(){

        System.out.println("privateMethod-----");
    }

    public ShareData(){}
    public ShareData(String name, Integer age, String desc) {
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ShareData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}