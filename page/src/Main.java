import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("a", "b"));
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
    }
}
