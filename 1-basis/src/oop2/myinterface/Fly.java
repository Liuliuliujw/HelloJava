package oop2.myinterface;

/**
 * 接口
 * 1、接口中不能有实例变量只能声明静态常量(static final),不写的话编译器会给我们添上
 * 2、接口中的方法默认为 public static修饰的,不写的话编译器会给我们添上
 * 3、java8之后 接口中可以声明默认方法(default)和静态方法(static),他们默认是public的，但静态方法可以声明为private的
 * <p>
 * 接口一般用于某种能力或规范的抽象，它可以限定实现类的方法和提供一些默认的功能，它也可以是空的用来标识实现类
 * <p>
 * 接口和抽象类的区别：
 * 类是单继承的而接口是多继承(多实现)的；
 * 接口中的方法和变量声明有限制；
 * 子类调用接口的方法的方式和抽象类不同
 *
 * @author llliujw
 */
public interface Fly {

    //相当于 public static int MAX_SPEED = 500;
    int MAX_SPEED = 500;

    //相当于 public abstract void fly();
    void fly();

    //after java 8
    default void ready() {
        System.out.println("准备起飞……");
    }

    //after java 8
    static void landing() {
        System.out.println("降落……");
    }
}
