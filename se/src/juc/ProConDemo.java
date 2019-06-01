package juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareSource {

    private int i = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (i != 0) {
                condition.await();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + i);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void dec() throws InterruptedException {
        lock.lock();
        try {
            while (i == 0) {
                condition.await();
            }
            i--;

            System.out.println(Thread.currentThread().getName() + i);
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}

public class ProConDemo {


    public static void main(String[] args) {

        ShareSource shareSource = new ShareSource();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareSource.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareSource.dec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();


    }
}
