import pojo.Girl;
import pojo.girl.Wangmeili;
import proxy.GirlProxy;

public class Test {

    public static void main(String[] args) {
        Girl girl = new Wangmeili();

        GirlProxy girlProxy = new GirlProxy(girl);

        Girl proxy = (Girl) girlProxy.getProxyInstance();

        proxy.data();
        System.out.println(girl.getClass());
        System.out.println(girl.getClass().getInterfaces()[0]);
        System.out.println(girl.getClass().getInterfaces()[1]);

        Wangmeili wangmeili = new Wangmeili();
        System.out.println(wangmeili.getClass().getInterfaces());


        Integer[] array = new Integer[] {1, 2, 3};
        System.out.println(array);

        int[] intarray = new int[] {1, 2, 3};
        System.out.println(intarray);

        boolean[] boolarray = new boolean[] {true, false, true};
        System.out.println(boolarray);

        Object[][][] obj = new Object[1][2][3];
        System.out.println(obj);


    }
}
