package hello;

/**
 * @author llliujw
 */
public class MyTest {
    public static void main(String[] args) {
        testPrint();
    }

    private static void testPrint(){
        //print 输出; println 输出+换行
        System.out.print("A,");
        System.out.print("B");
        System.out.println();
        //1.29E7 原因是String.valueOf(double)在10^-3 -- 10^7按十进制输出否则按科学技术法输出
        double d = 12900000;
        System.out.println(d);
        //printf 格式化输出
        double s = 3.1415926;
        System.out.printf("%.2f\n", s); // 显示两位小数3.14
        System.out.printf("%.4f\n", s); // 显示4位小数3.1416
        System.out.printf("--> %s\n\n","END"); // --> END
    }
}
