package study.thread;

public class ThreadInterrupt {
    public static void main(String[] args) {
        //表达式new出线程
        Thread t = new Thread(()->{
            //设置死循环
            for(;;){
                //判断线程是否被标记过
                if (Thread.interrupted()){
                    System.out.println(" This is the thread being marked ");
                    System.out.println(Thread.interrupted());
                }
            }
        });
        t.start();
        //设置标志位
        t.interrupt();
    }
}
