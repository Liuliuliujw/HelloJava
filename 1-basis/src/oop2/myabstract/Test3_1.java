package oop2.myabstract;

/**
 * @author llliujw
 */
public class Test3_1 {

    public static void main(String[] args) {
        Person student = new Student("张三", 18);
        Person teacher = new Teacher("李四", 28);
        student.to();
        teacher.to();
        teacher.run();
        student.run();
        student.hello(); //子类从抽象类继承的静态方法可以用过子类实例调用
    }
}
