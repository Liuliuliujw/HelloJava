package oop2.myenum;

/**
 * 枚举类
 * 1、枚举类与普通类结构相似，但它必须在类的开始声明所有的类实例
 * 2、枚举类的对象是单例的，通过 EnumClass.EnumInstance 的形式获取实例
 * 3、枚举类的隐式超类是java.lang.Enum<E>，所以它不允许继承其他的类
 *
 *  ## 枚举如何实现单例
 *  ## 枚举和常量的对比
 *  ## ……
 *
 * @author llliujw
 */
public enum SeasonEnum {
    SPRING("春天", "spring"),
    SUMMER("夏天", "summer"),
    AUTUMN("秋天", "autumn"),
    WINTER("冬天", "winter");
    //枚举类的字段也可以是非final类型，即可以在运行期修改，但是不推荐这样做！
    private final String chinese;
    public final String english;

    SeasonEnum(String chinese, String english) {
        this.chinese = chinese;
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }
}
