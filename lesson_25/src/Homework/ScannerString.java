package Homework;

import java.util.Scanner;

public class ScannerString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your string: \n");
        String inStr = scanner.nextLine();

        String[] words = inStr.split(" ");
        System.out.println("\nQuantity of words in string: " + words.length + "\n");

        String[] letters = inStr.split("");
        System.out.println("Quantity of letters in string: " + letters.length + "\n");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }
}

