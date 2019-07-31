package chapter5;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");

        final List<Stream<String>> collect = words.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(toList());

        int[] nums = {1, 2, 3};

        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a+b);
        System.out.println(sum);

        nums = new int[]{};
        OptionalInt min = Arrays.stream(nums).reduce(Integer::min);
        try {
            System.out.println(min.orElseThrow(()-> new Exception("Not Found")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*外部迭代*/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        System.out.println(map.get(5));

        Object o = 1;
        int i = 1;
        System.out.println(o.equals(i));


    }
}

class InfiniteStream {
    public static void main(String[] args) {
//        Stream.iterate(0, n -> n + 2).parallel().filter(x -> x % 5 == 0).forEach(x -> System.out.println(x));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
        IntStream twos = IntStream.generate(new IntSupplier(){
            int x = 1;
            public int getAsInt(){
                x++;
                return 2;
            }
        });

        List<int[]> l = new ArrayList<>();
        l.add(new int[]{1, 2});
        int[][] arr = new int[1][2];
    }
}
