package chapter2;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("12", "68", "12");
        int[] a = {1, 2, 3};
        System.out.println(list);
        list.sort(Comparator.comparingInt(Integer::valueOf));
        System.out.println(list);


        String s = " hello! world   This is too   great!         ";
        String[] array = s.split(" {3,}");
        System.out.println(Arrays.deepToString(array));

//        int[] nums = {1, 2, 3, 4};
////        res              1  1  2  6
////        res              24 12 8  6
//        System.out.println(Arrays.toString(Solution.productExceptSelf(nums)));

        Test.bufferWrite();


    }
    public static void bufferWrite() {
        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/chapter2/hello.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/chapter2/bufferello.txt"));
            ){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                //bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

//class Solution {
//    public String reverseWords(String s) {
//        String[] array = s.split(" +");
//        List<String> list = Arrays.asList(array);
//        list.sort(Comparator.reverseOrder());
//        return String.join(" ", list);
//
//
//    }
//
//    public static int[] productExceptSelf(int[] nums){
//        int[] res = new int[nums.length];
//
//        int acc = nums[0];
//        for (int i = 1; i < nums.length; i++){
//            res[i] =  acc;
//            acc = acc * nums[i];
//        }
//
//        acc = nums[nums.length - 1];
//        res[0] = 1;
//        for (int i = nums.length - 2; i >=0; i--){
//            res[i] = acc * res[i];
//            acc = acc * nums[i];
//        }
//        return res;
//
//    }
//}
