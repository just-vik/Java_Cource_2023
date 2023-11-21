package practice;

//Напишите программу для машины на светофоре.
//Что нужно делать, если горит красный, жёлтый или зелёный свет.
//Цвет светофора задается в программе, затем с клавиатуры.

import java.util.Scanner;

public class Ampel {
    public static void main(String[] args) {

        // Как будем кодировать цвет светофора?
        // либо цифрами 1,2,3; либо задаем в программе строкой(переменная тип String), либо вводит строку

        Scanner scanner = new Scanner(System.in);
        System.out.printf("What is the color? (Red, Yellow, Green): ");
        String color = scanner.next(); // задаем переменную строкового типа String

        switch (color) {
            case "Red" -> System.out.printf("Stop, wait!");
            case "Yellow" -> System.out.printf("Be ready to go.");
            case "Green" -> System.out.printf("Go-Go-Go");
            default -> System.out.printf("Wrong input!");
        }

    }
}
