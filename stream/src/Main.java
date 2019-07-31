import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("4");
        map.put("Hello", list);
        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        map.put("Hey", list2);
        final List<P> collect = list2.stream().flatMap(list2_element -> {
            System.out.println(list2_element);
            return list.stream()
                .map(list1_element -> {
                    System.out.println(list2_element);
                    return new P(list1_element, list2_element);
                });
        }).collect(
            toList());
        System.out.println(collect);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        // flatMap升维度
        List<int[]> pairs = numbers1.stream().flatMap(x -> numbers2.stream().map(y -> new int[]{x, y}))
            .collect(Collectors.toList());
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

//        System.out.println(map.values());
//        map.values().stream().filter(l->l.size()>1).forEach(v-> System.out.println(v));
//        final List<String> collect = list2.stream().collect(toList());
//        System.out.println(collect);
        Integer a = 1;
        System.out.println(a.compareTo(2));

    }
}



class P {
    String list1E;
    String list2E;

    public P(final String list1E, final String list2E) {
        this.list1E = list1E;
        this.list2E = list2E;
    }

    @Override
    public String toString() {
        return "P{" +
            "list1E='" + list1E + '\'' +
            ", list2E='" + list2E + '\'' +
            '}';
    }
}

class Anagrams {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(g -> System.out.println(g.size() + ": " + g));
        }

    }
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}

