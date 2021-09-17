package practice.thread;

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
