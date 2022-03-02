package oop2.myenum;

/**
 * @author llliujw
 */
public class Test3_3 {
    public static void main(String[] args) {
        SeasonEnum seasonEnum = SeasonEnum.SPRING;
        System.out.println(test1(seasonEnum));

        //验证枚举是单例的
        SeasonEnum seasonEnum1 = Enum.valueOf(SeasonEnum.class, "SPRING");
        System.out.println(seasonEnum1.equals(seasonEnum));
    }

    private static String test1(SeasonEnum season){
        StringBuilder str = new StringBuilder(season.toString()).append(":").append(season.getChinese());
        switch (season){
            case SPRING -> str.append("，万物复苏");
            case SUMMER -> str.append("，炎炎夏日");
            case AUTUMN -> str.append("，秋风送爽");
            case WINTER -> str.append("，凛冬将至");
        }
        return str.toString();
    }
}
