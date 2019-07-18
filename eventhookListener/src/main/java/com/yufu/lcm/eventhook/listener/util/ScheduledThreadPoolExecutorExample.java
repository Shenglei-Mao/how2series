package com.yufu.lcm.eventhook.listener.util;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPoolExecutorExample
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {

//        Runnable runnabledelayedTask1 = new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println(Thread.currentThread().getName()+" is Running Delayed Task1");
//            }
//        };
//
//
//        Runnable runnabledelayedTask2 = new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println(Thread.currentThread().getName()+" is Running Delayed Task2");
//            }
//        };
//
//        Runnable runnabledelayedTask3 = new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println(Thread.currentThread().getName()+" is Running Delayed Task3");
//            }
//        };
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++){
            int taskNum = i;
            Runnable runnabledelayedTask = new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println(Thread.currentThread().getName()+" is Running Delayed Task" + taskNum);
                }
            };
            scheduledPool.scheduleWithFixedDelay(runnabledelayedTask, 1, 1, TimeUnit.SECONDS);
        }


        Callable callabledelayedTask = new Callable()
        {

            @Override
            public String call() throws Exception
            {
                return "GoodBye! See you at another invocation...";
            }
        };



//        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask1, 1, 1, TimeUnit.SECONDS);
//        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask2, 1, 1, TimeUnit.SECONDS);
//        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask3, 1, 1, TimeUnit.SECONDS);

//        ScheduledFuture sf = scheduledPool.schedule(callabledelayedTask, 4, TimeUnit.SECONDS);
//
//        String value = (String) sf.get();
//
//        System.out.println("Callable returned"+value);

//        scheduledPool.shutdown();
//
//        System.out.println("Is ScheduledThreadPool shutting down? "+scheduledPool.isShutdown());
    }
}
