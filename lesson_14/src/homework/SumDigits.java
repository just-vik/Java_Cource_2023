package homework;

import java.util.Scanner;

//Составьте программу, которая вычисляет сумму чисел от 1 до 1/n, n вводится с клавиатуры.
//Пример: n = 10
//sum = 1 + 1/2 + 1/3 + ... + 1/10 Использовать цикл for.
public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input value n: ");
        int n = scanner.nextInt();
        double sum = 0; //переменная для хранения результата
        for (int i = 1; i <= n; i++) {
            sum = sum + 1.0 / i;
        }
        System.out.printf("Sum digits from 1 to 1/" + n + " = " + sum);
    }
}
