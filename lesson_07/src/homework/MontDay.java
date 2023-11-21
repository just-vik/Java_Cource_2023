package homework;

import java.util.Scanner;

public class MontDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the month: ");
        int mount = scanner.nextInt();
        System.out.println("Input the year: ");
        int year = scanner.nextInt();

        int dayMonth = 30;
        int res = 0;

        switch (mount) {
            case 1 -> {
                res = dayMonth + 1;
                System.out.println("January is " + res + " days");
            }
            case 2 -> {
                if ((((year % 4) == 0) | ((year % 100) == 0)) && ((year % 400) == 0)) {
                    res = dayMonth - 1;
                    System.out.println("February is " + res + " days, leap year");
                } else {
                    res = dayMonth - 2;
                    System.out.println("February is " + res + " days");
                }
            }
            case 3 -> {
                res = dayMonth + 1;
                System.out.println("March is " + res + " days");
            }
            case 4 -> System.out.println("April is " + dayMonth + " days");
            case 5 -> {
                res = dayMonth + 1;
                System.out.println("May is " + res + " days");
            }
            case 6 -> System.out.println("June is " + dayMonth + " days");
            case 7 -> {
                res = dayMonth + 1;
                System.out.println("July is " + res + " days");
            }
            case 8 -> {
                res = dayMonth + 1;
                System.out.println("August is " + res + " days");
            }
            case 9 -> System.out.println("September is " + dayMonth + " days");
            case 10 -> {
                res = dayMonth + 1;
                System.out.println("October is " + res + " days");
            }
            case 11 -> System.out.println("November is " + dayMonth + " days");
            case 12 -> {
                res = dayMonth + 1;
                System.out.println("December is " + res + " days");
            }
            default -> System.out.println("Incorrect digits");
        }


    }
}


