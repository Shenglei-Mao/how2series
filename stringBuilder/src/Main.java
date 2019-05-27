public class Main {

    public static void main(String[] args) {
        StringBuffer res = new StringBuffer();
//        StringBuilder res = new StringBuilder();
        System.out.println("The initial string is: ");
        System.out.println(res);
	    Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                res.append("Hello");
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{

            try {
                t1.join();
            }catch (Exception e){
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++){
                res.append("World");
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
//            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("The final string is: ");
        System.out.println(res);
    }
}
