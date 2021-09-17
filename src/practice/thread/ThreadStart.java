package practice.thread;

public class ThreadStart {

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("this is MyThread");
        }
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("this is the MyRun ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(10);
        new Thread(new MyRun()).start();
        myThread.interrupt();
        Thread thread = new Thread(() -> {
            System.out.println("this is x->{}");
        });
        thread.start();
    }
}
