package practice.thread;

/*
 * 生产者生产矿泉水，消费者获取矿泉水消费
 * */
public class ThreadMineralWater {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Thread t1 = new Thread(producer);
        Consume consume = new Consume(factory);
        Thread t2 = new Thread(consume);
        t1.start();
        t2.start();
    }
}

