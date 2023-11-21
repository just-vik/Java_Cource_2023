package homework;

import java.util.Scanner;

public class Seasons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number between 1 and 12: ");
        int number = scanner.nextInt();

        switch (number) {
            case 3, 4, 5:
                System.out.println("Spring \uD83C\uDF38");
                break;
            case 6, 7, 8:
                System.out.println("Summer  ☀\uFE0F");
                break;
            case 9, 10, 11:
                System.out.println("Autumn \uD83C\uDF41");
                break;
            case 12, 1, 2:
                System.out.println("Winter ❄\uFE0F");
                break;
            default:
                System.out.println("Incorrect \uD83D\uDE45\u200D\uFE0F");
        }

    }
}