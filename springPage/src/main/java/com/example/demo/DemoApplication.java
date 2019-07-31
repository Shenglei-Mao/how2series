package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
//        testPutAll();
        testSpringPage();




    }

    private void testSpringPage() {







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

    private void testPutAll() {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        map.put(1, l1);
        map.put(2, Arrays.asList("c", "d"));
        map.put(3, Arrays.asList("e", "f"));

//        map.forEach((k, v) -> {
//            System.out.println("key: " + k);
//            System.out.println("value: " + v);
//        });

        /*Pythonic way to print a map o(￣▽￣)ｄ*/
        final List<Map.Entry<Integer, List<String>>> collect = map.entrySet().stream().collect(Collectors.toList());
        System.out.println(collect);


        /*Try putAll method of Map*/
        Map<Integer, List<String>> copied_map = new HashMap<>();
        copied_map.putAll(map);
        System.out.println(copied_map.entrySet().stream().collect(Collectors.toList()));


        /*Change the value of the original map*/
        map.get(1).add("g");
        System.out.println("Original Map is: " + map.entrySet().stream().collect(Collectors.toList()));
        System.out.println("Copied Map is: " + copied_map.entrySet().stream().collect(Collectors.toList()));

        /*Arrays.asList not support for add and remove method*/

        /*List returned form Array.asList not work for primitive type array*/
        int[] data = {1,2,3,4,5};
        List list = Arrays.asList(data);
        System.out.println("列表中的元素数量是：" + list.size());
        System.out.println("元素类型：" + list.get(0).getClass());
        System.out.println("前后是否相等："+ data.equals(list.get(0)));
        System.out.println(list.get(0));

        /*Change the primitive to packed data type, the Array.asList works okay*/
        Integer[] packedData = {1,2,3,4,5};
        List listOfPackedData = Arrays.asList(packedData);
        System.out.println("列表中的元素数量是：" + listOfPackedData.size());

        System.out.println(list.getClass());
    }


}
