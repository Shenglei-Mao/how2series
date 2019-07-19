public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");
//        try {
//            foo.third(printThird);
//            foo.second(printSecond);
//            foo.first(printFirst);
//
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread t1 = new Thread(()->{
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
