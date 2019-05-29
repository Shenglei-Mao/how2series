import java.util.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++){
//            list.add(i);
//        }

        /*
        说明iter对于list来说是有序的
        */
//        Iterator<Integer> iter = list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }


//        int num = Integer.parseInt("00");
//        System.out.println(num != 0);

//        try {
//            System.out.println("Inside try");
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("Inside finally");
//
//        }
//        System.out.println("At the end");
        String a = "\1\2";
        System.out.println(a);
        System.out.printf("%s %s %n", a, a);
//        a.replaceAll("\\", "\\\\");
        a = a.replaceAll("\1", "\\\\1");
        a = a.replaceAll("\2", "\\2");
        System.out.println(a);


        String b = "\\a\\b";
        System.out.println(b);
        String c = "\\\\1";
        System.out.println(c);
    }
}
