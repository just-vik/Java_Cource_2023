package homework;

//Для всех задач задайте массив из 10 случайных чисел
//в интервале от -10 до 10.
//Протестируйте работу методов на созданном массиве.
//Задача 1. Написать метод, принимающий массив целых чисел,
//и возвращающий сумму всех его нечетных элементов (не индексы!, а сами элементы).
public class OddElements {
    public static void main(String[] args) {
        int[] odd = new int[10];
        int a = -20;
        int b = 20;
        for (int i = 0; i < odd.length; i++) {
            odd[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        for (int i = 0; i < odd.length; i++) {
            System.out.print(odd[i] + " ");
        }

        int sum = sumOddElements(odd);
        System.out.println("\nSum odd elements = " + sum);

    }

    public static int sumOddElements(int[] arr) {
        int res = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                res += num;
            }
        }
        return res;
    }
}
