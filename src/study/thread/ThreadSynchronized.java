
/*
    锁 为了提高安全性 cpu是没有线程的概念，只负责计算，但是线是无序的，为了保证有序可以选择枷锁 谁要使用必须先获取锁
    Synchronized  加锁后会大大降低效率
    Synchronized 保证可见性和原子性
    Synchronized 可重入锁 ，在执行线程一时调用线程二 线程二执行完成后才会继续执行线程一
    Synchronized 如果一个线程加Synchronized 另一个不加 执行会产生脏读
    Synchronized 如果产生异常会释放锁
*/
package study.thread;
public class ThreadSynchronized{
    private static int count;

    private static final Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "奇数线程").start();
    }

}
