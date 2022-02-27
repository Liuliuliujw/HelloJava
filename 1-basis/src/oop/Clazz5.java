package oop;

/**
 * static、final、内部类
 * <p>
 * 对于static：
 * 1、在类装载到JVM的时候执行或初始化
 * 2、被static修饰的对象不依赖于类的实例存在而是被类的实例对象所共享，我们可以不用创建类实例而直接使用它。
 * 3、static代码块或方法中不用使用实例属性和方法
 * <p>
 * 对于final
 * 1、final修饰的变量必须在构造方法执行完成前赋值，且只能赋值一次，否则编译错误
 * 2、final修饰的方法不能被子类覆盖重写，但可以被重载
 * 3、final修饰的类不能被继承
 * <p>
 * 对于内部类
 * 1、内部类可以访问其外部类的私有变量，其外部类也可以访问其私有变量
 * 2、非静态的内部类在除它和它的子类外的地方创建 需要先创建其外部类的对象 如: new Clazz5.new Son3();
 *
 * @author llliujw
 */
public class Clazz5 {

    private static final int kk = 2;
    public int var = 4;
    public static int staticVar = 5;
    public final int finalVar1;
    public static final int finalVar2;

    {
        System.out.println("构造代码块执行");
        finalVar1 = 6;
        System.out.println("var--> " + var);
//        finalVar2 = 7;  //由于静态代码块是先执行的，不能再修改finalVar2的赋值
        staticVar = 8;
    }

    static {
        System.out.println("静态代码块执行");
        System.out.println("staticVar--> " + staticVar);
//        finalVar1 = 6; //static修饰的 代码块或方法 中不能操作非静态的变量和方法
        finalVar2 = 7;
        System.out.printf("内部类Son2的私有静态变量kk-->%d\n", Son2.kk);
    }

    public Clazz5() {
        System.out.println("Clazz5构造方法执行");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public final int sub(int a, int b) {
        return a - b;
    }

    /*
    可以同时使用static和final修饰方法，这样是可以通过编译的，但idea会给出warning，是因为禁止静态方法在子类中的重写
    一般不具有太大的意义 如果在一些特殊的场景下你需要static和final同时修饰方法，你可以无视这个warning或者在
    Java | Class structure | 'static' method declared 'final' 禁用编辑器对这一项的检查
    参阅: https://intellij-support.jetbrains.com/hc/en-us/community/posts/206822805-What-is-the-point-of-the-static-method-declared-final-inspection-
     */
    public static final void ok() {
    }

    class Son1 {
        //        private static int kk = 3; //非静态的内部类在Java16前是编译不通过的。
        {
            System.out.println("Son1实例被创建");
        }
    }

    static class Son2 {
        private static final int kk = Clazz5.kk + 1;

        {
            System.out.println("Son2实例被创建");
        }
    }

    final class Son3 {
        {
            System.out.println("Son3实例被创建");
        }
    }

    static final class Son4 {
    }
}
