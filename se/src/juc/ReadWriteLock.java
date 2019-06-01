package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class  ReadWrite {

  private  volatile Map<String, Object> map = new HashMap<>();


   private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void put(String key, Object value) throws InterruptedException {

        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入" + key);
            Thread.sleep(300);
            map.put(key, value);

            System.out.println(Thread.currentThread().getName()+"写入完成-----------------------------------");

        } finally {
            lock.writeLock().unlock();
        }


    }


    public void get(String key) throws InterruptedException {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取" + key);
            Thread.sleep(300);
            Object value = map.get(key);

            System.out.println(Thread.currentThread().getName()+"读取完成-----------------------------------"+value);
        } finally {
            lock.readLock().unlock();

        }



    }

}


public class ReadWriteLock {
    public static void main(String[] args) {
        ReadWrite readWrite=new ReadWrite();

        for (int i = 0; i <5 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    readWrite.put(finalI +"", finalI +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)
         ).start();
        }
        for (int i = 0; i <5 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    readWrite.get(finalI +"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)
            ).start();
        }

    }


}
