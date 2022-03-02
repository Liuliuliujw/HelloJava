package oop2.myinterface;

/**
 * @author llliujw
 */
public class SuperMan implements Fly {
    private int speed;

    SuperMan(int speed) {
        this.speed = speed;
    }

    @Override
    public void fly() {
        String tip = speed > MAX_SPEED ? "超速啦" : "";
        System.out.printf("超人起飞，%dkm/h高速移动，%s\n", speed, tip);
//        landing();  //这里调用是使用本类的静态方法
    }

    //覆盖接口提供的默认方法
    @Override
    public void ready() {
        Fly.super.ready(); //调用实现接口default方法
        System.out.println("超人弹射起步");
    }

    //尝试覆盖接口的静态方法
    public static void landing() {
        System.out.println("超人降落》》》");
    }
}
