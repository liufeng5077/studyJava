package practice.thread;

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
