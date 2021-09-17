package study.thread;

public class ThreadInterruptAndSleep {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                //线程睡眠1000毫秒
                Thread.sleep(1000);
                //当出现sleep wait join时要终止线程需要抛出异常InterruptedException,当抛出异常后怎样处理看自己实际情况
            } catch (InterruptedException e){}
            System.out.println("this is ThreadInterrupt");
            System.out.println(Thread.currentThread().isInterrupted());
        });
        t.start();
        //终止线程
        t.interrupt();
    }
}
