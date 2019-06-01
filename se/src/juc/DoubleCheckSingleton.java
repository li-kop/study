package juc;

/**
 * @author : LJQ
 * @date : 2019/5/16 16:01
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
        System.out.println("--------------");
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {

            instance = new DoubleCheckSingleton();
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
