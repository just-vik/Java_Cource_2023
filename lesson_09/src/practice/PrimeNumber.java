package practice;

import java.util.Scanner;

// Пользователь вводит натуральное число n.
// Определите, является ли оно простым.
// Простое число - это такое число, которое делится только на себя и на 1.
// Примеры: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, ...
public class PrimeNumber {
    public static void main(String[] args) {
        // Алгоритм:
        //любое целое n, будем пробовать делить на числа меньшие его,
        //начиная с 2
        // пример_ 10/2=5 -это значит Не простое, делим на 2,3,4,...,10
        // если не разделилось то число простое
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int number = scanner.nextInt();

        boolean isPrime = true; // ответ будет разделилось/не разделилось
        int div = 2; //div - это делитель

        while (div < number) {
            if (number % div == 0) { // если разделилось число number нацело на div оно станет непростым
                isPrime = false;
                //может быть выход из цикла
            }
            div++; //увеличиваем параметр цикла
        }
        System.out.println(number + " is prime: " + isPrime);
    }
}
