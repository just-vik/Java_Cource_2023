package homework;

import java.util.Scanner;

// Написать программу для "Кофе-машины",
// которая позволяет пользователю выбрать напиток:
// Эспрессо -1
// Американо -2
// Латте -3
// Капучино -4
// После выбора программа должна сообщить стоимость выбранного напитка

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Espresso \n2 - Americano \n3 - Latte\n4 - Cappuccino\n5 - Water \nInput number your choose: ");
        int number = scanner.nextInt();
        double espresso = 2.5;
        double americano = 2.8;
        double latte = 3.5;
        double cappuccino = 3;

        switch (number) {
            case 1 -> System.out.println("Good choose, enjoy your Espresso \nPrice:" + espresso + "€");
            case 2 -> System.out.println("Good choose, enjoy your Americano\nPrice:" + americano + "€");
            case 3 -> System.out.println("Good choose, enjoy your Latte\nPrice:" + latte + "€");
            case 4 -> System.out.println("Good choose, enjoy your Cappuccino\nPrice:" + cappuccino + "€");
            case 5 -> System.out.println("Today is very hot, enjoy your Water\nPrice: FREE");
            default -> System.out.println("Incorrect number, try again");
        }
    }

}
