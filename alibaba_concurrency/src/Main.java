import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean res;

    public static void main(String[] args) {
        System.out.println(3 ^ 2 ^ 3);
        System.out.println(iftrue(res));
        System.out.println(res);
        String s = "Hello World";
        System.out.println(s.substring(0, 1));
    }

    private static boolean iftrue(boolean input){
        return input = true;
    }
}
