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

//设置一个生产物品
class MineralWater {
    int id; //矿泉水编号

    //生成有参构造
    public MineralWater(int id) {
        this.id = id;
    }

    //生成toString方法
    @Override
    public String toString() {
        return "MineralWater{" +
                "id=" + id +
                '}';
    }
}

//设置一个工厂
class Factory {
    int index = 0;
    //设置组数生产x组矿泉水
    MineralWater[] mineralWater = new MineralWater[20];

    //设置一个空间将生产的矿泉水放入空间锁保证安全
    public synchronized void poth(MineralWater min) {
        //判断容器是否到达最大
        while (mineralWater.length == index) {
            //如果到达最大值则让线程等待
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        //唤醒另一个线程
        this.notify();
        mineralWater[index] = min;
        index++;
    }

    //从该空间获取矿泉水
    public synchronized MineralWater pop() {
        //空间如果没有矿泉水，那么让线程暂停
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        //唤醒另一个线程
        this.notify();
        //没消费一个就会减少一个
        this.index--;
        return mineralWater[index];
    }
}

//生产者类
class Producer implements Runnable {
    Factory f = null;

    Producer(Factory f) {
        this.f = f;
    }

    @Override
    public synchronized void run() {
        //开始生产
        for (int i = 0; i < 20; i++) {
            MineralWater min = new MineralWater(i);
            f.poth(min);
            System.out.println("生产了" + min + "个矿泉水");
            try {
                //每次生产休眠10毫秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

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