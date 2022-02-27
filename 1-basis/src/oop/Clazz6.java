package oop;

/**
 * static、final、内部类
 *
 * @author llliujw
 */
public class Clazz6 extends Clazz5 {
    public final int finalVar1;
    public static final int finalVar2 = 6;
    private static final int jj = 8;

    Clazz6() {
        finalVar1 = 2;
//        super.finalVar1 =3; //父类final修饰的属性，子类可以重写覆盖但不能修改
        new Son1();
        new Son2();
        new Clazz5.Son2();
        new Son3(); //在Clazz5的子类之外创建非静态内部类Son3的实例则需要通过 new Clazz5().new Son3(); 完成
    }

    //static 方法可以被重写
    public static int add(int a, int b) {
        return 0;
    }

    //final 修饰的方法不能被重写 但能被重载
    public int sub(int a) {
        return a;
    }
//    public int sub(int a, int b) {
//        return 0;
//    }

    class Son2 {
        {
            System.out.println("子类Son2实例被创建");
        }
    }
    //final修饰的类不能被继承
//    class Son3 extends Clazz5.Son3 {}
}
