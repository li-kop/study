package com.ljq;

/**
 * @author : LJQ
 * @date : 2019/5/24 17:41
 */
public class X99 {
    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {

                System.out.print(j + "*" + i + "=" + i * j + "" + "\t");
            }
            System.out.println();
        }
    }
}
