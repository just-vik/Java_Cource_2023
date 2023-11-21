package homework;

import java.util.Scanner;

// Вводится положительное целое число, найдите сумму его цифр.
public class DigitsSum1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int num = scanner.nextInt();
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        System.out.println("Sum of numbers: " + sum);
    }
}

