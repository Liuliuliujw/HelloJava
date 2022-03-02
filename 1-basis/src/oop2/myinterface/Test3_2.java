package oop2.myinterface;

/**
 * @author llliujw
 */
public class Test3_2 {

    public static void main(String[] args) {
        Fly plane = new Plane();
        Fly superMan = new SuperMan(600);
        plane.ready();
        plane.fly();
        Fly.landing(); //不能是plane.landing()或superMan.landing()
        superMan.ready();
        superMan.fly();
        SuperMan.landing(); //当superMan被声明为接口实例时，不能通过实例来调用静态方法
    }
}
