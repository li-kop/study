package com.ljq;

/**
 * @author : LJQ
 * @date : 2019/5/20 16:42
 */

/*.class创建对象的引用时，不会自动初始化该class对象
        Class.forName()会自动初始化该对象*/

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c1 = Base.class;

        System.out.println("-----------------------------------");

        Class<?> c2= Class.forName("com.ljq.Base");
    }

}
class Base{
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }

}