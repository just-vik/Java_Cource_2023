package homework;

import java.util.Scanner;

// Вводится шестизначное число (номер автобусного билета).
// Определите, является ли этот билет "счастливым"
// (сумма первых трех цифр равна сумме трех последних цифр).
public class LuckyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number your ticket: ");
        int number = scanner.nextInt();
        System.out.println("Your number is: " + number);

        int num1 = number / 100000;
        int num2 = (number / 10000) % 10;
        int num3 = (number / 1000) % 10;
        int num4 = (number / 100) % 10;
        int num5 = (number / 10) % 10;
        int num6 = number % 10;

        if (number <= 99999) {
            System.out.println("It's wrong number. Try Again");
        } else {
            while (num1 + num2 + num3 == num4 + num5 + num6) {
                System.out.println("Congratulations!!!\nYour ticket:  " + number + " is a Lucky !!!");
                break;
            }
            while (num1 + num2 + num3 != num4 + num5 + num6) {
                System.out.println("Your ticket is not a Lucky Ticket");
                break;
            }
        }

    }


}

