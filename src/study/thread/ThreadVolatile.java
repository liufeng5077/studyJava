package study.thread;

public class ThreadVolatile {

    //设置volatile初始值为一个Boolean值
    public static volatile  boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        //Volatile 可以让线程正常结束，但是不能精确循环次数 适应不依赖中间状态
        Thread t = new Thread(()->{
            long i =0L;
            while (running){
                i++;
            }
            System.out.println("end and i="+i);
        });
        //执行线程
        t.start();
        //让线程睡10毫秒
        Thread.sleep(10);
        //终止线程
        running=false;

        //第二种interrupt 同样无法精确
        Thread s = new Thread(()->{
            while (!Thread.interrupted()){
                System.out.println("!thread");
            }
        });
        s.start();
        Thread.sleep(10);
        s.interrupt();
    }
}
