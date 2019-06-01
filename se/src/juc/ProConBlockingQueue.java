package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int num = 1;
    private ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (num != 2) {
                c2.await();
            }
            for (int i = 6; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void print15() {
        lock.lock();
        try {
            while (num != 3) {
                c1.await();
            }
            for (int i = 16; i <= 30; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class ProConBlockingQueue {
    public static void main(String[] args) {
  ShareData shareData=new ShareData();
        for (int i = 0; i <10 ; i++) {
                    new Thread(() -> {
                    shareData.print5();
                            }, "AAA").start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(() -> {
                shareData.print10();
            }, "BBB").start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(() -> {
                shareData.print15();
            }, "CCC").start();
        }
    }

}
