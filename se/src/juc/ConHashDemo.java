package juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : LJQ
 * @date : 2019/5/14 16:09
 */
public class ConHashDemo {

    public static void main(String[] args) {

        Map map=new ConcurrentHashMap(16);
    }
}
