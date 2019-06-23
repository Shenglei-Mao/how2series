import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // create anonymous inner class object
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("New thread created");
            }
        }).start();


        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        List<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach(n -> System.out.println(n));

        // Using lambda expression to print even elements
        // of arrL
        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });




        //Driver Code
        String arr[] = {"5", "-1237637463746732323",
            "97987", "12" };
        sortLargeNumbers(arr);
        for (String s : arr)
            System.out.print(s + " ");

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println();
        map.forEach((key, value)-> {
            System.out.println("The key is: " + key);
            System.out.println("The value is: " + value);
        });
    }

    // Function for sort an array of large numbers
    // represented as strings
    static void sortLargeNumbers(String arr[])
    {
        // Refer below post for understanding below expression:
        // https://www.geeksforgeeks.org/lambda-expressions-java-8/
        Arrays.sort(arr, (left, right) ->
        {
            /* If length of left != right, then return
               the diff of the length else  use compareTo
               function to compare values.*/
            if (left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });
    }


}
