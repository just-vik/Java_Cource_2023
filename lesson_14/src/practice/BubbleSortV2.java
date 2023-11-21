package practice;

public class BubbleSortV2 {
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
    // **печать числового массива**
    public static void printArray(int[] arr) { //(int[] arr)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //печатает поочереди элементы массива
        }
        System.out.println();
    }
}
