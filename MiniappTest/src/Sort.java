import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void largeDataSort(){
        /*
        10亿级别排序
        */
//        System.out.println("Start the sorting algorithm");
//        Float[] arr= new Float[100000000*2];
//
//        for (int i = 0; i < 100000000*2; i++){
//            Random random=new Random();
//            float v = random.nextFloat() * 50f;
//            arr[i]=v;
//        }
//        System.out.println();
////        for (int i = 0; i < 1000000; i++){
////            System.out.println(arr[i]);
////        }
//        float sizeOfArr = (float)100000000*2 * 4 / 1024 / 1024 / 1024; //unit is GB
//        System.out.println("10亿级别float总共消耗内存为： " + sizeOfArr + "GB");

//        long sortStartTime = System.currentTimeMillis();
//        Arrays.sort(arr);
//        long sortEndTIme = System.currentTimeMillis();
//        System.out.println("10亿级别排序时间： " + (sortEndTIme - sortStartTime));
//        arr = null;  //GC not works when make arr to null
        //Damn, no GC for primitive type array!
//        arr = null;
////        System.gc();




        System.out.println("Start the sorting algorithm");
        Integer[] arr= new Integer[100000000];
        Random random = new Random();
        for (int i = 0; i < 100000000; i++){

            int v = random.nextInt();
            arr[i]=v;
        }
        System.out.println();
//        for (int i = 0; i < 1000000; i++){
//            System.out.println(arr[i]);
//        }
        float sizeOfArr = (float)100000000 * 4 / 1024 / 1024 / 1024; //unit is GB
        System.out.println("10亿级别float总共消耗内存为： " + sizeOfArr + "GB");

//        System.gc();
        Integer[] arr0 = new Integer[100000000];
        for (int i = 0; i < 100000000; i++){

            int v = random.nextInt();
            arr0[i]=v;
        }
        System.out.println("Array0 建立完毕");
//        Arrays.fill(arr, null);
//        arr = null;
//        long startTime = System.currentTimeMillis();
//        System.gc();
//        System.out.println("GC in Main end, total time: " + (System.currentTimeMillis() - startTime));
    }
}
