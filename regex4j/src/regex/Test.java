package regex;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : Michael M
 */
public class Test {
    private final static String EMPTY_STRING = "";
    static Pattern emailPattern = Pattern.compile(".....@purdue.edu");
    static Pattern numberPattern = Pattern.compile("\\d+");
    static Pattern alphabaticPattern = Pattern.compile("[a-zA-z]+");

    public static void main(String[] args) {
        String email = "mao59@purdue.edu";
        System.out.println(emailPattern.matcher(email).matches());
        System.out.println(emailPattern.matcher(email).find());
        System.out.println(emailPattern.matcher(email).find(1));
        Matcher emailMatcher = emailPattern.matcher(email);
        emailMatcher.matches();
        System.out.println(emailMatcher.group());
        System.out.println(email.length());
        System.out.println(emailMatcher.start());
        System.out.println(emailMatcher.end());
        System.out.println(emailMatcher.groupCount());

        System.out.println("----------------------------------------------------");
        String number = "mao59@purdue.edu@123@12";
        Matcher numberMatcher = numberPattern.matcher(number);
        numberMatcher.matches();
        while (numberMatcher.find()) {
            System.out.print("The start index is: " + numberMatcher.start() + ".");
            System.out.println(" And the value is: " + numberMatcher.group() + ".");
        }

        System.out.println(Character.isAlphabetic('['));
        int i = 1;
        System.out.println(++i);
        while(++i < 10) {

        }
        System.out.println(i);
        String s = "";
        s = "# " + s;
        System.out.println(s);
        System.out.println(Character.isDigit(1));

        StringBuilder sb1 = new StringBuilder("Hello ");
        StringBuilder sb2 = new StringBuilder("World");
        sb1.append(sb2);

        Integer integer = new Integer(1000);
        System.out.println(integer == 1000);
    }
}
