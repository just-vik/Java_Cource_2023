package practice;
//Задан массив целых чисел: 75, 34, -15, -123, 57, -145, 86, 77, 48, -59.
//Найдите минимальный элемент массива и его индекс.
//Напечатайте все элементы массива с НЕчетными индексами.
//Найдите произведение всех четных элементов массива.

public class ArrayExample {
    public static void main(String[] args) {

        int[] array = {75, -250, -15, -123, 57, -145, 86, -250, 48, -250};
        //int m = minElOfArray(array) - вместо значения m на печать пишем метод
        System.out.println("Min element of array is: " + minElOfArray(array));

        System.out.println("Index Min element of array is: " + minElOfArrayIndex(array));

    } // =========== end of main ============

    // ============= methods ===============

    public static int minElOfArrayIndex(int[] arr) {
        int min = arr[0];
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= min) { //если элемент массива с индексом i < min
                min = arr[i];
                indexMin = i;
            }
        }
        return indexMin;
    }

    public static int minElOfArray(int[] arr) {
        //пробегаем по массиву, каждый элемент сравним с min
        //если элемент будет <min то делаем min = элементу
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) { //если элемент массива с индексом i < min
                min = arr[i];
            }
        }
        return min; //закрываем метод
    }
}

// ============= end of methods ===============


//    public static int sumOddElements(int[] arr) {
//        int res = 0;
//        for (int num : arr) {
//            if (num % 2 != 0) {
//                res += num;
//            }
//        }
//        return res;



