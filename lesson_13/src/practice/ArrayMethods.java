package practice;

import java.util.Scanner;

public class ArrayMethods {
    // **печать числового массива**
    public static void printArray(int[] arr) { //(int[] arr)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //печатает поочереди элементы массива
        }
        System.out.println();
    }

    //================================================================================
    // **печать текстового массива**
    public static void printArray(String[] arr) { //(String[] arr)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //печатает поочереди элементы массива
        }
        System.out.println();
    }

    //================================================================================
    // ** Maximum elements(type Int)**
    public static int maxArray(int[] arr) {
        int max = arr[0];  // первое приближение для максимума
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //================================================================================
    // ** INDEX for Maximum elements **
    public static int maxArrayIndex(int[] arr) {
        int max = arr[0];  // первое приближение для максимума
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

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
    // ** Пузырьковая сортировка от меньшего к большему **
    public static int[] sortArray(int[] arr) {
        int min = arr[0];
        int indexMin = 0;//взяли за первое 0
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            indexMin = i;
            //запускаем цикл фор который ищет более минимальный
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    indexMin = j;
                }
            }
            //переставляем минимальный элемент в начало,
            //а тот вместо которого ставим отправляется в правую часть массива
            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
        return arr;//возвращает отсортированный массив целых чисел
    }

    //================================================================================
    // ** Пузырьковая сортировка от большему к меньшего **

    public static int[] sortArrayIntAsc(int[] arr) {
        int max; //= arr[0];
        int index; //= 0;//взяли за первое 0
        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            index = i;
            //запускаем цикл фор который ищет более минимальный
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            //переставляем минимальный элемент в начало,
            //а тот вместо которого ставим отправляется в правую часть массива
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;//возвращает отсортированный массив целых чисел
    }

    //================================================================================
    // ** метод печатает строку разделитель **
    public static void split() {
        System.out.println("---------------------------------------------------------------------");
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
    // ** Bubble sort **
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { //правый конец будет двигаться к началу
                if (arr[j] > arr[j + 1]) { //если левый из соседей больше правого, то меняем их местами
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}






