package oop2.myabstract;

/**
 * @author llliujw
 */
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("学生开始做作业");
    }
}
