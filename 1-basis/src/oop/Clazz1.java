package oop;

/**
 * 类结构、继承、多态
 *
 * @author llliujw
 */
public class Clazz1 {

    int var;
    //构造代码块 ，会在构造方法之前执行
    {
        System.out.println("构造代码块执行");
    }
    //构造方法
    public Clazz1(int var) {
        this.var = var;
        System.out.println("构造方法执行");
    }

    protected void print() {
        System.out.println(var);
    }

    //方法重载，多态的表现
    public void print(int var1) {
        System.out.println(var1);
    }
}
