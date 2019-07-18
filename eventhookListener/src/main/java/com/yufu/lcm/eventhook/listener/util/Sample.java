package com.yufu.lcm.eventhook.listener.util;

import cn.hutool.core.lang.Singleton;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@Data(staticConstructor = "of")
//@Accessors(chain = true)
@ToString
@Builder
public class Sample {
    int x, y;
//    int x;
//    String s;
//    public Sample(int x, int y){
//        this.x = x;
//        this.y = y;
//    }

//    public Sample(int x, String s){
//        this.x = x;
//        this.s = s;
//    }
//    public Sample(String s, int x){
//        this.x = x;
//        this.s = s;
//    }




    public static void main(String[] args) {
//        Sample s = new Sample(1, 2);
//        Sample s1 = Sample.of().setX(1).setY(2);
//        Sample s2 = Sample.of().setX(1).setY(2);
////        System.out.println(s);
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.hashCode() == s2.hashCode());
        Sample s = Sample.builder().x(1).y(2).build();
        System.out.println(s);
//        testThreadGroup();
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(()->{
            lock.lock();
            Thread thread = Thread.currentThread();
            System.out.println(thread);
            while(true){

            }

        }).start();

        final Thread thread = Thread.currentThread();
        System.out.println(thread);
        lock.lock();
        System.out.println("Hello World");
        lock.unlock();

    }

    private static void testThreadGroup(){
       new Thread(()->{
           final Thread thread = Thread.currentThread();
           System.out.println(thread);

       }).start();
    }
}
