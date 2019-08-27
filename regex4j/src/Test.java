import java.util.EnumSet;

/**
 * @author : Michael M
 */
public class Test {
    public static void main(String[] args) {
        AbstractGraph abstractGraph = new AbstractGraph() {};
        AbstractGraph abstractGraph2 = new AbstractGraph() {};
        System.out.println(abstractGraph);
        System.out.println(abstractGraph2);

        final EnumSet<WeekEnum> weekEnums = EnumSet.allOf(WeekEnum.class);
        System.out.println(weekEnums);
    }




}

enum WeekEnum {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}