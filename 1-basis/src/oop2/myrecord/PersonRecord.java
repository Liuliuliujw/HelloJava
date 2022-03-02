package oop2.myrecord;

/**
 * 记录类
 * 1、记录类与普通类结构相似，但它不允许实例变量的存在
 * 2、记录类会根据传入记录变量生成final实例变量和对应的 Getter方法(格式: 变量名())，以及对应的toString()、hashCode()、equals()方法
 * 3、枚举类的隐式超类是java.lang.Record，所以它不允许继承其他的类
 * 4、记录类是final修饰的，不可被继承
 * <p>
 * 记录类一般被用来记录不可变的数据
 *
 * @author llliujw
 */
public record PersonRecord(String name, int age) {

    //记录类中不允许创建实例变量，即必须被static修饰
    private final static int ADULT_AGE = 18;

    //方法里可以使用记录的变量
    public void hello() {
        String tip = age >= ADULT_AGE ? "成年了" : "未成年";
        System.out.printf("我叫%s，今年%d岁，%s", name, age, tip);
    }

}
