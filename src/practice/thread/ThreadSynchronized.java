package practice.thread;

/*
 * 用Synchronized实现两个线程交互打印
 * */
public class ThreadSynchronized {

    private static volatile int count;

    //new 一个锁
    private static volatile Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <
                    99) {
                synchronized (object) {
                    if ((count & 1) == 0) {
                        count++;
                        System.out.println(Thread.currentThread().getName() + ":" + count);
                    }
                }
            }
        }, "线程一正在打印奇数...").start();
        new Thread(()->{
            while (count<100){
                synchronized (object){
                    if ((count & 1) == 1){
                        count++;
                        System.out.println(Thread.currentThread().getName()+":"+count);
                    }
                }
            }
        },"线程二正在打印偶数...").start();
    }
}
