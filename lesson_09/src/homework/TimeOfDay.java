package homework;

import java.util.Scanner;

//Определение времени суток. Напишите программу,
//которая принимает текущий час (от 0 до 23) и выводит приветствие
//в зависимости от времени суток (утро, день, вечер, ночь).
public class TimeOfDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input time from 0 to 23: ");
        int time = scanner.nextInt();

        switch (time) {
            case 0, 1, 2, 3, 4, 5 -> System.out.println("Good night!");
            case 6, 7, 8, 9, 10, 11 -> System.out.println("Good morning!");
            case 12, 13, 14, 15, 16, 17 -> System.out.println("Good day!");
            case 18, 19, 20, 21, 22, 23 -> System.out.println("Good evening!");
            default -> System.out.println("Wrong time, try again");
        }
    }
}
