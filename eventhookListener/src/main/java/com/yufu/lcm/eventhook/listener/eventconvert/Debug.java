package com.yufu.lcm.eventhook.listener.eventconvert;

import io.netty.channel.ChannelPromiseAggregator;
import scala.Int;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Debug {
    public static void main(String[] args) {
        int i = 0;
//        while(true){
//            printMessage(i++);
//        }
//        Integer integer = 3;
//        System.out.println(integer instanceof Integer);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        Consumer<Integer> c1 = v -> {
//            v = v + 1;
//            v = v * 2;
//            System.out.println(v);
//        };
//
//        Consumer<Integer> c2 = v-> System.out.println(v);
//
//
//        c1.andThen(c2).accept(1);


    }
    private static void printMessage(int i){
        System.out.println(i);
    }



}
class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x)
            return Integer.compare(this.x, that.x);
        else if (this.y != that.y)
            return Integer.compare(this.y, that.y);
        else
            return Integer.compare(this.val, that.val);
    }
}