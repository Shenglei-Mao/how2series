public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Test test = new Test();

            Thread t1 = new Thread(() -> {
                test.set(3);
            });

            Thread t2 = new Thread(() -> {
                System.out.println(test.get());
            });
            t1.start();
            t2.start();


        }
    }
}
