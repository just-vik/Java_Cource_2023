package practice.coffee;

import java.util.Scanner;

public class CoffeeAppl {
    public static void main(String[] args) {
        System.out.println("Welcome to Coffee Shop!");
        //We offer a menu to choose
        Coffee[] menu = Coffee.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + "-" + menu[i].getType());
        }
//        Coffee[] menu = Coffee.values();
//        int i = 1;
//        for (Coffee coffee : menu) {
//            System.out.println(i + "-" + coffee.getType());
//            i++;


        while (true) {
            System.out.println("Input your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Your choice is: " + menu[choice - 1].getType());
                    System.out.println("The price is: " + menu[choice - 1].getPrice());
                    break;
                }
                //расскопировать cases
                default: {
                    System.out.println("Wrong choice.");
                }
            }
        }


    }
}
