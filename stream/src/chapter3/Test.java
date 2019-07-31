package chapter3;

public class Test {
    public static void main(String[] args) {
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        r.run();

    }

}
