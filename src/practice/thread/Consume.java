package practice.thread;

//消费者
class Consume implements Runnable {
    Factory f = null;

    public Consume(Factory f) {
        super();
        this.f = f;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 20; i++) {
            MineralWater m = f.pop();
            System.out.println("消费者一共消费了" + m + "个矿泉水");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
