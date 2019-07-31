package com.shenglei.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Hello World");

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("Code", 120);
        map1.put("UUID", "NOT EXIST");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("UUID", 11);
        list.add(map2);

        System.out.println(list);
    }

}
