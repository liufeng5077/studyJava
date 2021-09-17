package practice.thread;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("this is the 't' ");

                try {
                    Thread.sleep(1000);
                    System.out.println("----");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        });
        t.start();
        Thread.sleep(10);

    }
}
