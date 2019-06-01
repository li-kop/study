package juc;

import java.util.concurrent.atomic.AtomicReference;

class Spin {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "-------------Mylock");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {

        Thread thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "-------------MyUnlock");
        atomicReference.compareAndSet(thread, null);

    }

}


public class SpinLockDemo {
    public static void main(String[] args) throws Exception {

        Spin spin = new Spin();

        new Thread(
                () -> {
                    spin.myLock();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    spin.myUnLock();
                }, "t1"
        ).start();

        Thread.sleep(1000);

        new Thread(
                () -> {
                    spin.myLock();
                    spin.myUnLock();
                }, "t2"
        ).start();

    }

}
