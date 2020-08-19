import java.util.*;
import java.util.function.Function;

public class Test {

    private int attribute;

    public int add(int a, int b) {
        return 0;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Test{" +
                "attribute=" + attribute +
                '}';
    }

    public List<List<Integer>> groupThePeople(int[] gz, Function<? super Test, ? extends Test> mappingFunction) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < gz.length; ++i) {
            List<Integer> list = groups.computeIfAbsent(gz[i], k -> {
                k = k + 1;
                return new ArrayList<>();
            });
            list.add(i);
            if (list.size() == gz[i]) {
                res.add(list);
                groups.put(gz[i], new ArrayList());
            }
        }
        return res;
    }
}


