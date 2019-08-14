
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMap {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

//        list.stream().flatMap(e -> getListByElement(e).stream()).forEach(x-> System.out.println(x));
//
//        System.out.println(System.nanoTime() / 1000000000 / 60);

        list.parallelStream().forEach(System.out::println);


    }

    private static List<Integer> getListByElement(Integer id) {
        return IntStream.rangeClosed(0, id).boxed().collect(Collectors.toList());

    }
}
