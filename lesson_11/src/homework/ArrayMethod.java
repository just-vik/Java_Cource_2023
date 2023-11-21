package homework;

//Написать метод, принимающий массив целых чисел, и разворачивающий его.
//Последний элемент становится нулевым, предпоследний, первым, и т. д.
//Подсказка: этот метод должен изменить полученный массив.
public class ArrayMethod {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        int a = -10;
        int b = 10;
        fillArray(myArray, -10, 10);
        printArray(myArray);
        System.out.println("====================================");
        System.out.println("Sum of odd elements is = " + sumOfOddElements(myArray));
        // System.out.println("Multiplication of elements with even indexes is: " + multOfElEvenIndex(myArray));
        System.out.println("====================================");
        reverseArray(myArray);
        printArray(myArray);
    } //======================= end of main =========================

    //======================= Methods =========================

    //reverse array
    public static void reverseArray(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];//берем левый элемент во временную переменную
            arr[i] = arr[arr.length - 1 - i] = temp;//меняем местами левый с правым
        }
    }

    public static void multOfElEvenIndex(int[] arr) {
        int mult = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) { // проверяем индекс на четность
                mult *= arr[i];
            }
        }
    }

    //filling array
    public static int sumOfOddElements(int[] arr) {
        int sumOfOddEl = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sumOfOddEl += arr[i];
            }
        }
        return sumOfOddEl;
    }

    //filling array
    public static void fillArray(int[] arr, int a, int b) {
        for (int i = 0; i < arr.length; i++) { //обходим пробегаем все элементы массива
            arr[i] = (int) (Math.random() * (b - a + 1) + a); //в элемент массива кладется случайное число
        }
    }

    //print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    //======================= End of methods =========================
}
