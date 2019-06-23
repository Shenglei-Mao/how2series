import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.Arrays;

@Data
public class threeDots {

    String dot1;

    public static void main(String[] args) {
        /*case1
            Single String
         */
        method1("Hello World");

        /*case2
            String array
         */
        String[] stringArray = new String[3];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "Hey there";
        }
        method1(stringArray);

        /*case3  NOT WORKING!
            List of String
         */
//        List<String> list = new ArrayList<>(3);
//        for (int i = 0; i < 3; i++){
//            list.add("Hello World");
//        }
//        method1(list);

        /*case4
            null
         */
//        method1(null);
    }

    private static void method1(@NotNull final String... fieldNames) {
        System.out.println(fieldNames);
        System.out.println(Arrays.deepToString(fieldNames));

//        List<String> list = new ArrayList<>();
//        System.out.println(list);
//
//        Integer[] intArray = new Integer[5];
//        System.out.println(intArray);
    }

}

class test {
    public static void main(String[] args) {
        threeDots td = new threeDots();

        System.out.println(td);
        td.setDot1("dot1");
        System.out.println(td.getDot1());

        System.out.println(td.canEqual(new Integer(1)));
        System.out.println(td);

        System.out.println("你好");
    }
}
