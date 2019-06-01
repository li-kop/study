package juc;


import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
                int i=100;
                }, "t1").start();
    }
}
