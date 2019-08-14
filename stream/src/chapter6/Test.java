package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = String.valueOf(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}

class RegexMatches {

    public static void main(String args[]) {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
//        String pattern = "(.*)(\\d+)(.*)";
        String pattern = "(\\w)+";


        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        while (m.find()) {
//            System.out.println("Found value: " + m.group(0));
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
//            System.out.println("Found value: " + m.group(3));
//            System.out.println("Found value: " + m.group(4));
            System.out.println(m.group(0));
        }

        String s1 = "Hello World I am coming";
        String[] patterns1 = s1.split(" ", 2);
        System.out.println(s1.split(" ", 2)[1]);
//        System.out.println(Arrays.toString(patterns1));

//        int x = -1;
//        if (!x) {
//            System.out.println(x);
//        }
        String[] strs = new String[]{"Hello", "World", "I", "am", "coming!"};
        Map<String, List<String>> map = Arrays.stream(strs)  //Stream<String>
            .collect(Collectors.groupingBy(s -> {
                final char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }));
        System.out.println(map);

        StringBuilder sb = new StringBuilder("Hell");
        testStringBuilder(sb);
        System.out.println("sb in main: " + sb);


        String s = "Hell";
        testString(s);
        System.out.println("string in main: " + s);

        System.out.println(Runtime.getRuntime().availableProcessors());



    }

    private static void testStringBuilder(StringBuilder sb) {
        sb.append("llo");
        System.out.println(sb);
    }

    private static void testString(String s) {
        s = s + "llllo";
        System.out.println(s);
    }
}


