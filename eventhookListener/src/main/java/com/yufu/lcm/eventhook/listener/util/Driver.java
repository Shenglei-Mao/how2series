package com.yufu.lcm.eventhook.listener.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Driver {
    public static void main(String[] args) {
        Point p1 = Point.of(1, 2);
        Point p2 = Point.of(1,2);
        System.out.println(p1 == p2);


        List<String> l = new ArrayList<>();
        l.add("Hello");
        l.add("Hi");
        Consumer<String> action = element -> System.out.println(element);
        l.forEach(action);

        Optional<String> optionalS = Optional.ofNullable("Hello World");
        System.out.println(optionalS.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "Nice";
            }
        }));


    }
}
