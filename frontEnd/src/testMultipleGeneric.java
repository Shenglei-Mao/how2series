public class testMultipleGeneric implements multipleGeneric<Integer, String> {
    @Override
    public String create(final Integer input) {
        return input.toString();
    }

    public static void main(String[] args) {
        testMultipleGeneric t = new testMultipleGeneric();
        System.out.println(t.create(2));
    }
}


class testMultipleGeneric2 implements multipleGeneric<String, String> {

    @Override
    public String create(final String input) {
        return input;
    }

    public static void main(String[] args) {
        testMultipleGeneric2 t = new testMultipleGeneric2();
        System.out.println(t.create("Okay"));
    }


}

