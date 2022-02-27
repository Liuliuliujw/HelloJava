package oop;

/**
 * @author llliujw
 */
public class MyTest {

    public static void main(String[] args) {
        //类结构、继承、多态 -- clazz1、clazz2
        test1();
        //访问控制符 -- clazz3、clazz4
        test2();
        //static、final、内部类 -- clazz5、clazz6
        test3();
    }

    static void test1() {
        System.out.println("---> test1 <---");
        Clazz1 clazz1 = new Clazz1(1);
        clazz1.print();
        clazz1.print(3);
        new Clazz2().print();
        System.out.println("---> END\n");
    }

    static void test2() {
        System.out.println("---> test2 <---");
        Clazz4 clazz4 = new Clazz4();
        System.out.println(clazz4.publicVar);
        System.out.println(clazz4.protectedVar);
        System.out.println(clazz4.var);
        clazz4.setPrivateVar(4);
        System.out.println(clazz4.getPrivateVar());
        System.out.println("---> END\n");
    }

    static void test3() {
        System.out.println("---> test3 <---");
        Clazz6 clazz6 = new Clazz6();
        System.out.printf("Clazz6-finalVar1: %d\n", clazz6.finalVar1);
        System.out.printf("Clazz6-finalVar2: %d\n", Clazz6.finalVar2);
        System.out.printf("Clazz6-add: %d\n", Clazz6.add(3, 2));
    }
}
