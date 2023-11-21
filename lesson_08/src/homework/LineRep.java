package homework;

import java.util.Scanner;

// Программа получает на вход строку и число повторений этой строки
// Программа должна вывести эту строку нужное количество раз.
public class LineRep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the text you want to repeat: ");
        String text = scanner.next();
        System.out.println("Number of repeat: ");
        int rep = scanner.nextInt();

        int count = 0;

        while (count < rep) {
            System.out.println(text);
            count++;
        }
    }
}
