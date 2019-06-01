/**
 * @author : LJQ
 * @date : 2019/5/16 16:25
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock instance = null;

    private DoubleCheckLock() {
        System.out.println(Thread.currentThread().getName() + "--------------");
    }

    private static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
