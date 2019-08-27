package com.test;

import com.service.IService;

import java.awt.print.Pageable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;

/**
 * @author : Michael M
 */
public class Test {

    public static void main(String[] args) {
        while (true) {

            ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);

            for (IService service : serviceLoader) {

                System.out.println(service.getScheme() + "=" + service.sayHello());

            }

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 1;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
