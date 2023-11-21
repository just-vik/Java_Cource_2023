package homework;


import java.util.Arrays;
import java.util.Comparator;


public class OddEvenComparator implements Comparator<Integer> {


    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("========================================");
    }
    @Override
    public int compare(Integer o1, Integer o2) {

        return (o1%2)-(o2%2);
    }

}

