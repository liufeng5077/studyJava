package study.thread;

import java.util.concurrent.*;

public class NewThread {

    //第一种方法,继承
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("hello MyThread");
        }
    }

    //第二种，实现
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("hello MyRun");
        }
    }

    //第三种用于返回有返回值的
    static class MyCall implements Callable<String> {
        @Override
        public String call() {
            System.out.println("hello MyCall");
            return "success";
        }
    }

    public static void main(String[] args) throws Exception {
        //启动线程的五种方式
        //第一种
        new MyThread().start();
        //第二种方式
        //跟第一种方式相比第二种更好，因为第二种可以继承其他接口
        new Thread(new MyRun()).start();
        //第三种线程池
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();
        //拿到有返回类型的返回值
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> f = service.submit(new MyCall());
        //阻塞
        String s = f.get();
        System.out.println(s);
        //第四种，不用线程池用线程拿到返回值
        FutureTask<String> task = new FutureTask<String>(new MyCall());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
        service.shutdown();
    }
}
