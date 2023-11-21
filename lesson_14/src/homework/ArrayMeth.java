package homework;

import java.util.Scanner;

public class ArrayMeth {
    // ** сортировка от меньшего к большему **
    public static int[] minMax(int[] arr) {
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
    // ** от большему к меньшего **
    public static int[] maxMin(int[] arr) {
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
    public static void printArray(int[] arr) { //(int[] arr)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //печатает поочереди элементы массива
        }
        System.out.println();
    }

    //================================================================================
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

    public static void split() {
        System.out.println("---------------------------------------------------------------------");
    }
}








