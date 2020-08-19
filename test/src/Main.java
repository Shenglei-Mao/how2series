public class Main {

    public static void main(String[] args) {

        char a = '3';
        char b = '0';
        char c = '1';
        String s1 = "3";
        String s2 = "4";
        String s3 = s1 + s2;
        System.out.println(s3);
        String s4 = s3 + a;
        System.out.println(s4);
        System.out.println(Integer.parseInt(s4) % 3);

    }
}
