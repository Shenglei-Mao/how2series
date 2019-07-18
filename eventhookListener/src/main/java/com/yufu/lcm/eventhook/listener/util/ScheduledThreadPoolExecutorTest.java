package com.yufu.lcm.eventhook.listener.util;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(15); // no
    static ScheduledFuture<?> t;

    static class MyTask implements Runnable {
        private int attempt = 1;

        public void run() {
            System.out.print(attempt + " ");
            if (++attempt > 5) {
//                t.cancel(false);
//                executor.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        /*异步*/
        MyTask task = new MyTask();
        t = executor.scheduleAtFixedRate(new MyTask(), 0, 1, TimeUnit.SECONDS);
        System.out.println("H");
        t.cancel(true);


        /*这里直接执行shutdown()是肯定不行的，但是如果不是runnable而是callable的话会不会等future job的get result的结果？也就是说future job是同步调用么？*/
//        executor.shutdown();
    }
}