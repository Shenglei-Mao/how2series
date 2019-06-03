package multithread;

import character.Hero;

public class TestThread {

    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){

                    //因为减血更快，所以盖伦的血量迟早会到达1
                    //使用while循环判断是否是1，如果是1就不停的循环
                    //直到加血线程回复了血量
                    while(gareen.hp==1){
                        continue;
                    }

                    gareen.hurt();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();

    }

}