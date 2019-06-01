package lock;

class ShareData{
    private Integer num=100;

    public  synchronized void sell(){
        num--;
        System.out.println(Thread.currentThread().getName()+"卖出第"+(100-num)+"张");
        if(num==0){

            System.out.println("卖票终止");
        }
    }
}

public class Ticket {
    public static void main(String[] args) {
        ShareData  data=new ShareData();
        new Thread(() -> {
                data.sell();
                        }, "AA").start();
        new Thread(() -> {
            data.sell();
        }, "BB").start();
        new Thread(() -> {
            data.sell();
        }, "CC").start();


    }
}
