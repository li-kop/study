import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : LJQ
 * @date : 2019/5/16 17:37
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);

        System.out.println( atomicInteger.compareAndSet(5,2019)+"\t"+ Thread.currentThread().getName()+atomicInteger.get());

        System.out.println( atomicInteger.compareAndSet(5,2018)+"\t"+ Thread.currentThread().getName()+atomicInteger.get());

    }
}
