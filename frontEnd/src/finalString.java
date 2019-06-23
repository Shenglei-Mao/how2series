import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class finalString {

    public static final String STRING = "string";

    public static void main(String[] args) {
        String a = "Hello World";
        a = "Damn good";
        System.out.println(a);



        /*
        不能改变f的指向！
         */
//        final String f = "This is a final String";
//        f = "What the hell";
//        System.out.println(f);
        List<String> list = new ArrayList<>();
        list.add(STRING);
        System.out.println(list);

        String prefix = "Shenglei";
        String result = String.format("%s-%s", prefix, UUID.randomUUID().toString().replace("-", ""));
        System.out.println(result);


    }


}
