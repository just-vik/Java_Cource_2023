package practice;

//Написать программу, которая по введенной цифре от 1 до 7 определяет день недели.
//Замените ввод цифры на первую букву дня недели.

import java.util.Scanner;

public class WeekDays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input day of week (two first letter of day): ");
        String dayOffWeek = scanner.next();

        //dayOffWeek=dayOffWeek.toLowerCase();

        switch (dayOffWeek) {
            case "Mo" -> System.out.printf("This is Monday.");
            case "Tu" -> System.out.printf("This is Tuesday.");
            case "We" -> System.out.printf("This is Wednesday.");
            case "Th" -> System.out.printf("This is Thursday.");
            case "Fr" -> System.out.printf("This is Friday.");
            case "Sa" -> System.out.printf("This is Saturday.");
            case "Su" -> System.out.printf("This is Sunday.");
            default -> System.out.printf("Wrong input!");
        }
    }
}
