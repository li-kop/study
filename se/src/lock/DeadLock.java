package lock;

class Lock implements Runnable {

    private String lockA;
    private String lockB;


    @Override
    public void run() {
        String lockA = "同步锁A";
        String lockB = "同步锁B";

        synchronized (lockA) {
            System.out.println("持有锁" + lockA + "---------" + "想获得" + lockB);
        }

        synchronized (lockB) {
            System.out.println("持有锁" + lockB + "---------" + "想获得" + lockA);
        }


    }
}


public class DeadLock {


    public static void main(String[] args) throws InterruptedException {


        Lock lock = new Lock();
        Thread thread = new Thread(lock);

        thread.start();

        Thread.sleep(Integer.MAX_VALUE);
    }


}
