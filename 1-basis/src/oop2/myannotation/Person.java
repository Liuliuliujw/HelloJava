package oop2.myannotation;

import java.lang.annotation.*;

/**
 * 注解 --java 1.5
 * 1、注解用@interface关键字声明，默认实现了java.lang.annotation.Annotation接口
 * 2、注解的属性通过 数据类型 属性名() [可选：default 默认值]；的形式来声明
 * 3、通过 @注解类名(属性1=值1,...,属性n=值n)来使用注解，有默认值的属性可以不写对应的值，但注解所需的值只有一个时，可简化为 @注解类名(值)
 * <p>
 * 注解一般配合反射使用，获取标记目标的对象
 * <p>
 * 元注解：用于声明注解的注解
 * <code>@Retention     作用域</code>
 * -|RetentionPolicy.SOURCE 编译时丢弃
 * -|RetentionPolicy.CLASS  会被编译到类文件中，但在运行时不会被VM保留。(默认)
 * -|RetentionPolicy.RUNTIME会被编译到类文件中，且会被VM保留，可以参与反射
 * <code>@Target        目标</code>
 * -|ElementType.TYPE      类、接口(包括注释接口)、枚举或记录类
 * -|ElementType.FIELD     类实例变量
 * -|ElementType.METHOD    方法
 * ... ...
 * <code>@Inherited     目标子类继承</code>
 * <code>@Repeatable    可重用</code>
 * ... ...
 *
 * @author llliujw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Person {
    String name() default "";

    int age();
}
