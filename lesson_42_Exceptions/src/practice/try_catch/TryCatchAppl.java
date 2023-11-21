package practice.try_catch;

import java.util.Scanner;

public class TryCatchAppl {
    public static void main(String[] args) {

//        1. Деление на 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input first number: ");
            int a = scanner.nextInt();
            System.out.println("Input second number: ");
            int b = scanner.nextInt();
            int division = a / b;
            System.out.println("Division " + a + "/" + b + " = " + division);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        2. Выход за пределы массива;
        int[] arr = {73, -17, 99, 26, -45, 34, -83};
        int l = arr.length;
        System.out.println(l);

        try {
            arr[9] = 157;
        } catch (Exception e) {
            System.out.println(e.getMessage() + ", " + e.toString());
        }


//        3. Проверка ввода пользователя на корректность.
        Scanner scanner1 = new Scanner(System.in);
        try {
            System.out.println("Input number: ");
            int n = scanner1.nextInt();
            System.out.println("Your input: " + n);
        } catch (Exception e) {
            System.out.println(e.getCause() + "/ " + e.getMessage() + "/ " + "Wrong input");
        }
    }
}
