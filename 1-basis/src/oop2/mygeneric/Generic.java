package oop2.mygeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 泛型(parameter Type)
 * 1、概念：将类型参数化，在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型。
 * 2、意义：编译期间确定类型，减少ClassCastException的产生；提升可读性；增加代码可重用
 * 3、Java中的数组是协变的，但泛型是不变的；通过通配符可以实现泛型的协变和逆变 --(1)
 * 4、Java语言中的泛型实现方法是类型擦除，基于这种方法实现的泛型称为伪泛型  --(2)
 * 5、泛型的一些限制 ：
 * ---不能实例化和创建数组，因为类型不确定
 * ---模糊性错误，类有多个泛型存在时，统一实例方法泛型参数的重载可能冲突
 * ---静态方法，不能访问类的泛型成员变量
 * ---泛型类不能扩展 Throwable，即不可创建泛型异常类
 * ---堆污染，因为java的伪泛型   --(3)
 * <p>
 * ***()小标的详细理解见Test3_6例子注释
 *
 * @author llliujw
 */
public class Generic<T> {
    private T element;

    public Generic(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public static <E> E[] pickTwo(E a, E b, E c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(b, c);
            case 2:
                return toArray(a, c);
        }
        throw new AssertionError();
    }

    /*
        该例子来自《effective java》 第三版，在使用泛型变长参数时可能会产生堆污染
        该例子中的堆污染：由于编译时的类型擦除 toArray的参数是 Object[] 这将会导致 pickTwo返回的是 Object[] 而非期望的 E[]
        可以通过@SafeVarargs来压制IDE对堆污染的检查，但它并不会减少堆污染的产生，
        在一些条件下它是安全的：
         1.它没有在可变参数数组中保存任何值(不插入) 2.它没有对不信任的程序开放数组
     */
    @SafeVarargs
    private static <E> E[] toArray(E... args) {
        return args;
    }

    /**
     * 将多个list转换为一个list
     * <p>
     * 在消费场景下使用 <? extends T> 通配符
     *
     * @param lists 多个集合
     * @param <T>   元素类别
     * @return 集合
     */
    @SafeVarargs
    public static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    /**
     * 产生指定长度的随机数字集合并消费
     * <p>
     * 在生产场景下使用 <? super T> 通配符
     *
     * @param length 长度
     * @param list   目标集合
     */
    public static void addRandomNumber(Integer length, List<? super Number> list) {
        Random random = new Random();
        while (--length > 0) {
            switch (random.nextInt(4)) {
                case 0 -> list.add(random.nextInt(1));
                case 1 -> list.add(random.nextDouble(1));
                case 2 -> list.add(random.nextFloat(10));
                case 3 -> list.add(random.nextLong(1));
            }
        }
    }
}
