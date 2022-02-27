package oop;

/**
 * 类结构、继承、多态
 *
 * 对于继承，可以这么看：构造子类对象时，会先构造父类对象；子类调用方法时，如果子类重写了用子类的否则调用父类的方法。
 *
 * @author llliujw
 */
public class Clazz2 extends Clazz1 {

    //子类可以覆盖父类的变量，但父类变量依然存在，可以通过 super 关键字调用
    int var = 5;

    //若父类没有无参的构造方法，子类必须在构造函数的开始显式调用父类构造方法
    public Clazz2() {
        super(0);
    }

    //方法重写: 覆盖父类的print()方法
    public void print() {
        System.out.printf("子类var: %d\n父类var: %d\n", var, super.var);
    }
}
