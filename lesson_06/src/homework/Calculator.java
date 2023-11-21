package homework;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1st number: ");
        int number1 = scanner.nextInt();
        System.out.println("Input 2nd number: ");
        int number2 = scanner.nextInt();
        System.out.println("1 =>  +\n2 =>  -\n3 =>  *\n4 =>  /\n5 =>  %\nSelect operation: ");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Result: %d" + number1 + number2);
                break;
            case 2:
                System.out.println("Result: " + (number1 - number2));
                break;
            case 3:
                System.out.println("Result: " + number1 * number2);
                break;
            case 4:
                System.out.println("Result: " + number1 / number2);
                break;
            case 5:
                System.out.println("Result: " + number1 % number2);
                break;
            default:
                System.out.println("Operation not found");
                break;
        }
    }
}
