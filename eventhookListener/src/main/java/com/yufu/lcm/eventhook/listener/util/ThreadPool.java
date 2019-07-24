package com.yufu.lcm.eventhook.listener.util;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        Runnable runnable = () -> {
            System.out.print("1 ");

//            try {
//                throw new IOException("A self defined IOException");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

}
