package utilclass;

/**
 * 包装类
 * 1、将基础数据类型以final类的形式封装，除此之外，它还提供了处理对应类型常用的一系列方法
 * 2、装箱: 基础数据类型->包装类，拆箱： 包装类->基础数据类型；java1.5后在编译时提供自动装箱和拆箱的机制
 * ---包装类通过valueOf()装箱，***Value()拆箱，parse***()从字符串转换为本类型；(在java9之后获取包装类的含参构造函数被标识为过时并废除)
 * 3、除Character和Boolean外的六个数值型包装类都继承自Number，它提供所有数值包装类的***Value()方法用于相互转换；
 * 4、Java采用Unicode进行字符处理，char本质是固定两字节的无符号正整数，存储字符对应的Unicode ID
 * 4、除了Float和Double外的包装类的ValueOf方法存在缓存，在一定范围内的返回对象从缓存中取
 * ---Boolean用类常量缓存, Byte、Short、Integer、Long的缓存范围是[-128,127], Character的缓存范围是[0,127], Integer的缓存上限可修改
 *
 * @author llliujw
 */
public class WrapperTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 自动拆箱和装箱
     */
    private static void test1() {
        Integer obj1 = Integer.valueOf(1); //手动装箱
        int temp1 = obj1.intValue(); //手动拆箱

        Integer obj2 = 10; //自动装箱
        int temp2 = obj2; //自动拆箱
        obj2++; //直接利用包装类的对象进行数学计算
        System.out.println(temp2 * obj2);

        System.out.println("TEST 1 ------> END\n");
    }

    /**
     * 数值类型间的相互转换
     */
    private static void test2() {
        Number number1 = 3.5f; //float
        Number number2 = 8321312312L; //long 超过Integer.MAX_VALUE
        //通过Number类的方法进行不同数值型数据类型的转换，若通过强制类型转换可能会抛出ClassCastException（如float->int）
        int number3 = number1.intValue(); //高精度向低精度转换时，会向下取整丢失精度
        System.out.printf("float:3.5f -> int:%d\n", number3);
        int number4 = number2.intValue(); //大范围向小范围转换时，若在小范围的取值区间内取余数
        System.out.printf("double:8321312312L ->int:%d, 验证:%d\n", number4, verify((long) number2));

        System.out.println("TEST 2 ------> END\n");
    }

    /**
     * 验证大范围数向小范围数转换时，超出范围时的转换机制
     *
     * @param l 大范围数
     * @return 转换后的小范围数
     */
    private static long verify(long l) {
        long intRange = (long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE + 1;
        long mod = (l - (long) Integer.MIN_VALUE) % intRange;
        long result = Integer.MIN_VALUE + mod;
        return result;
    }

    /**
     * char与int转换
     */
    private static void test3() {
        //字符向数值转换
        Character character = '8';
        System.out.printf("character - 0 --> %d\n", character - 0); //与 (int)character 和 Integer.valueOf(character) 这些写法等效
        System.out.printf("character - '0' --> %d\n", character - '0');
        //数值向字符转换：合规范围
        System.out.printf("(char)25105 --> %s\n", (char) 25105); //char范围内的转换
        //数值向字符转换：超出范围
        char temp = (char) 165105; //尝试通过int强转获取Unicode编码为165105的字符
        System.out.printf("(char)165105 --> %s, 它的Unicode编码为:%d\n", temp, (int) temp); //超出char范围[0,65535]时不会报错，会按照大范围向小范围数的转换规则转换
        //数值向字符数组转换
        char[] chars = Character.toChars(165105); //实际获取Unicode编码为165105的字符
        System.out.printf("Character.toChars(165105) --> %s, length:%d\n", String.valueOf(chars), chars.length);

        System.out.println("TEST 3 ------> END\n");
    }

    /**
     * 测试包装类的缓存
     */
    private static void test4() {
        //验证Integer的缓存，其他数值型省略
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));
        //验证Character的缓存
        System.out.println(Character.valueOf((char) 127) == Character.valueOf((char) 127));
        System.out.println(Character.valueOf((char) 128) == Character.valueOf((char) 128));

        System.out.println("TEST 4 ------> END\n");
    }

}
