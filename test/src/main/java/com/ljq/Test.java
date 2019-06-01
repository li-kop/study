package com.ljq;

/**
 * @author : LJQ
 * @date : 2019/5/21 17:21
 */
public class Test {
    void  getName(){

        System.out.println("--------");
    }

    static void getAge(){

        System.out.println("++++++++++++++");
    }



    public static void main(String[] args) {

        Test.getAge();

        getAge();

        Test t=new Test();

        t.getName();



    }
}
