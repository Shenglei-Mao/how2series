public class Main {

    public static void main(String[] args) {
        Instance a = InstanceFactory.getInstance();
        Instance b = InstanceFactory.getInstance();
        System.out.println(a == b);
    }

}
