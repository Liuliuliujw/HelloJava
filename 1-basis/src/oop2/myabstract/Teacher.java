package oop2.myabstract;

/**
 * @author llliujw
 */
public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("老师开始收作业！");
    }
}
