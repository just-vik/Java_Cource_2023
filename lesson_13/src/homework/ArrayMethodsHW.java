package homework;

import java.util.Scanner;

public class ArrayMethodsHW {
    //================================================================================
    // ** Minimum elements(type Int)**
    public static int minArray(int[] arr) {
        int min = arr[0];  // первое приближение для максимума
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //================================================================================
    // ** INDEX for Minimum elements **
    public static int minArrayIndex(int[] arr) {
        int min = arr[0];  // первое приближение для максимума
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //================================================================================
    // ** Random method **
    public static int[] randomArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input qty elements: ");
        int elQty = scanner.nextInt();
        int[] arr = new int[elQty];
        int a = -100;
        int b = 100;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        return arr;
    }

    //================================================================================
    // ** print **
    public static void printArray(int[] arr) { //(String[] arr)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //печатает поочереди элементы массива
        }
        System.out.println();
    }

    //================================================================================
    // ** Пузырьковая сортировка от большему к меньшего **
    public static int[] sortArrayIntAsc(int[] arr) {
        int max = arr[0];
        int index = 0;//взяли за первое 0
        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            index = i;
            //запускаем цикл фор который ищет более минимальный
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }
}






