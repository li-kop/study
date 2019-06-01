package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {

    public synchronized void sendMessage() {

        System.out.println(Thread.currentThread().getName() + "----------------------------"+"sendMessage");
        sendEmail();
    }

    public synchronized void sendEmail() {

        System.out.println(Thread.currentThread().getName() + "sendEmail");
    }

    public  void  get(){

        System.out.println(Thread.currentThread().getName() + "----------------------------"+"get");
        set();
    }

    public void set() {
        System.out.println(Thread.currentThread().getName() + "----------------------------"+"set");
    }


    @Override
    public void run() {

        Lock lock=new ReentrantLock();
        lock.lock();
        try{ get();}catch (Exception e){
            e.printStackTrace();
        }
       lock.unlock();
    }
}


public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
      /*  new Thread(
                () -> {
                    try {
                        phone.sendMessage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                , "t1").start();*/

        Thread thread=new Thread(phone);
        thread.start();

    }

}
