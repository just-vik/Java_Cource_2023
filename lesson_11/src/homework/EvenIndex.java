package homework;

//Для всех задач задайте массив из 10 случайных чисел
// в интервале от -10 до 10.
// Протестируйте работу методов на созданном массиве.
//Задача 2. Написать метод, принимающий массив целых чисел,
// и возвращающий произведение всех его элементов с четными индексами.
public class EvenIndex {
    public static void main(String[] args) {

        int[] even = new int[10];

        int a = -20;
        int b = 20;
        for (int i = 0; i < even.length; i++) {
            even[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        for (int i = 0; i < even.length; i++) {
            System.out.print(even[i] + " ");
        }

        int prodSum = prodEvenElements(even);
        System.out.println("\nProduct even elements = " + prodSum);

    }

    public static int prodEvenElements(int[] arr) {
        int res = 1;
        for (int num : arr) {
            if (num % 2 == 0) {
                res *= num;
            }
        }
        return res;
    }
}
