package oop2.myabstract;

/**
 * 抽象类、抽象方法
 * 1、抽象类在声明时，需要在class关键字前加上abstract关键字，它包含0-n个抽象方法
 * 2、抽象类不能直接创建对象
 * 3、子类继承抽象类时，需要实现父类的抽象方法，否则也需要声明为抽象类
 * 4、抽象方法不能声明为私有的(private)
 * <p>
 * 抽象类一般用于一类事物的抽象，抽取同类事物的公共部分和通用行为
 *
 * @author llliujw
 */
public abstract class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void to() {
        System.out.printf("我的名字是%s，年龄是%d\n", name, age);
    }

    public static void hello() {
        System.out.println("hello");
    }

    protected abstract void run();
}
