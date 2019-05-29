import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        System.out.println('\u0009' == '\t');
//        System.out.println('\f');
//        System.out.println('\uffff');



//        Pattern p1 = Pattern.compile("\\ufff1");
//        Pattern p2 = Pattern.compile("\\uffff");
//        Pattern p3 = Pattern.compile("\\x70");
//        Pattern p4 = Pattern.compile("\\d*");
//        Pattern p5 = Pattern.compile(".*");
//        Pattern p6 = Pattern.compile("\\\\");
//
//
//        String a = "\uffff";
//        String b = "0x70";
//        String c = "1514321313";
//        String d = "\\";
//        System.out.println(a);
//        System.out.println(b);
//
//        Matcher m1 = p1.matcher(a);
//        Matcher m2 = p2.matcher(a);
//        Matcher m3 = p3.matcher(b);
//        System.out.println(m1.matches());
//        System.out.println(m2.matches());
//        System.out.println(m3.matches());
//        System.out.println(p4.matcher(c).matches());
//        System.out.println(p5.matcher(b).matches());


        System.out.println("----------------------------------------------------------");
        Pattern pattern = Pattern.compile("(([\\da-zA-z]+)@purdue\\.edu)");
        String a = "mao59@purdue.edu";
        String b = "@purdue.edu";
        String c = "mao@purdue.edu";
        String d = "mao59@google.com";
        String e = "google.edu";

        Matcher m1 = pattern.matcher(a);
        Matcher m2 = pattern.matcher(b);
        Matcher m3 = pattern.matcher(c);
        Matcher m4 = pattern.matcher(d);
        Matcher m5 = pattern.matcher(e);

        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
        System.out.println(m4.matches());
        System.out.println(m5.matches());
        System.out.println(m1.groupCount());
        System.out.println(m1.group(0));
        System.out.println(m1.group(1));
        System.out.println(m1.group(2));
        System.out.println(pattern.pattern());

        System.out.println("\\\\\\mao59@purdue.eduHello WORLD");
        Matcher matcher = pattern.matcher("\t\n\fmao59@purdue.eduHello WORLD");
        System.out.println(matcher.find());
        System.out.println(matcher.start());
        System.out.println(matcher.end());



    }
}
