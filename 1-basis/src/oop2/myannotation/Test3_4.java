package oop2.myannotation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author llliujw
 */
public class Test3_4 {
    public static void main(String[] args) {
        //模拟扫描包获取的类集合
        List<Class<?>> classList = new LinkedList<>();
        classList.add(Dog.class);
        classList.add(Student.class);
        classList.add(Teacher.class);

        //输出集合中@Person标记的类名
        classList.forEach(clz -> {
            if (clz.isAnnotationPresent(Person.class)) System.out.println(clz.getName());
        });

        //获取并输出类Student上@Person注解的值
        Person annotation = Student.class.getAnnotation(Person.class);
        System.out.printf("学生名字：%s  年龄：%d", annotation.name(), annotation.age());
    }

    static class Dog {
    }

    @Person(name = "zmz", age = 18)
    static class Student {
    }

    @Person(age = 28)
    static class Teacher {
    }
}
