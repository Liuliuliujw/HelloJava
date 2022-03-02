package oop2.mygeneric;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author llliujw
 */
public class Test3_6 {

    public static void main(String[] args) throws NoSuchFieldException {
        test1();
        test2();
        test3();
    }

    /**
     * (1)的示例
     * 协变与逆变
     * 泛型的 PSCE原则 (Provide Super Consume Extends)
     */
    private static void test1() {
        System.out.println("--->test1");
        //由于子类对象的向上转型，使数组具有协变
        Number[] numbers = new Number[5];
        numbers[0] = 5;
        numbers[1] = 2.0;
        numbers[2] = 4.3f;
        for (Number number : numbers) {
            if (number != null) System.out.println(number);
        }
        System.out.println("--->END");
//        //同一泛型类赋值具有父子关系的类时不具有父子关系，示例：
//        List<Number> numberList = new ArrayList<Integer>();

        //利用extends通配符 <? extends T> 实现 泛型的协变
        List<? extends Number> numberList1 = new ArrayList<Integer>();
//        //以下注释的代码是不能通过编译的
//        numberList1.add(Double.valueOf(3));
//        numberList1.add(Float.valueOf(3));
//        numberList1.add(Integer.valueOf(3));
        numberList1.add(null);
        //取出是安全的
        Number number = numberList1.get(0);

        //测试集合合并 -- 泛型通配符在消费场景的应用
        List<String> list1 = List.of("马老师");
        List<String> list2 = List.of("张国伟");
        List<String> list3 = List.of("tlp");
        List<String> result = Generic.flatten(list1, list2, list3);
        result.forEach(System.out::println);
        System.out.println("--->END");

        List<? super Number> numberList2 = new ArrayList<>();
        //这两种也是ok的
        //List<? super Number> numberList2 = new ArrayList<Number>();
        //List<? super Number> numberList2 = new ArrayList<Object>();
        numberList2.add(Double.valueOf("3.6"));
        numberList2.add(Float.valueOf("3.8"));
        //只能以Object读
        Object object = numberList2.get(0);

        //测试添加若干随机数 -- 泛型通配符在生产场景的应用
        List<Number> list = new ArrayList<>();
        Generic.addRandomNumber(5, list);
        list.forEach(System.out::println);
        System.out.println("--->END");
    }

    /**
     * (2)的示例
     * 反射验证类型擦除
     * <p>
     * 1、对于泛型类签名，编译后会完全擦除为普通类
     * 2、对于泛型成员变量，编译后若限定了泛型上界则为上界的类型，否则为Object
     * 3、对于泛型方法，编译后会在方法签名中加上 varargs 标识
     * <p>
     * 实际上擦除的只是参数和自变量的类型，但会将泛型信息保存到Signature中，我们可以通过匿名类获取。
     * <p>
     * 为什么要类型擦除？ 1、若实现真泛型，则需要修改JVM源代码，2、若实现真泛型，会造成有泛型的版本和没有泛型的版本不兼容这违背了Java的设计理念
     */
    private static void test2() throws NoSuchFieldException {
        System.out.println("--->test2");
        //对于泛型类签名的验证
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass().equals(integers.getClass()));
        System.out.println("--->END");

        //查看泛型成员变量
        Class<?> genericClass = Generic.class;
        Field element = genericClass.getDeclaredField("element");
        element.setAccessible(true);
        System.out.printf("成员变量element的参数类型：%s，参数泛型类型：%s\n", element.getType(), element.getGenericType());
        System.out.println("--->END");
    }

    /**
     * (3)的示例
     * 堆污染
     * <p>
     * 我们可以在创建集合类的时候，通过泛型指定该集合类中应该存储的对象类型。如果在指定类型的集合中，引用了不同的类型，那么这种情况就叫做堆污染。
     */
    private static void test3() {
        try {
            //堆污染演示 这将会报出ClassCastException()
            Integer[] integers = Generic.pickTwo(3, 4, 5);
            System.out.println(integers.getClass().getName());
        } catch (ClassCastException e) {
            e.printStackTrace(System.out);
        }
    }
}
