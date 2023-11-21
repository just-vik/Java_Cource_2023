package homework;

import java.util.Scanner;

// Вводится положительное целое число, найдите сумму его цифр.
public class DigitsSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int num = scanner.nextInt();
        System.out.println((num % 10) + (num / 10) % 10 + (num / 100));
    }
}
