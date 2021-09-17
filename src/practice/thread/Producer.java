package practice.thread;

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
