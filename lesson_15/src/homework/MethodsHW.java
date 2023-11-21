package homework;

import java.util.Scanner;

public class MethodsHW {
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

    public static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -left - 1;
    }

//    public static int indexOf(int[] arr, int n) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if      (n < arr[mid]) right = mid - 1;
//            else if (n > arr[mid]) right = mid + 1;
//            else return mid;
//        }
//        return -1;
//    }

    public static int[] sortedSort(int[] arr) {
        int min = arr[0];
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            indexMin = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    indexMin = j;
                }
            }
            // переставляем минимальный элемент в начало
            int tmp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = tmp;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void split() {
        System.out.println("-------------------------------");
    }
//поиск положительных чисел в массиве и выдает в количестве новый массив
    public static int[] positiveNumSearch(int[] arr) {
        int count = 0;
        //пробегаем по массиву и считаем кол-во положительных чисел
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;//здесь посчиталось кол-во + чисел
            }
        }
        int[] arrPos = new int[count];//объявляем новый массив с длинной count
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arrPos[index] = arr[i];
                index++;
            }
        }
        return arrPos;
    }
}
