package homework.number_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NumbersSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter qty of numbers: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> numbers = new HashSet<>();

        System.out.println("Enter numbers:");
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            numbers.add(num); // Добавляем число в множество
        }
        // Удаляем числа больше 10 v1
//        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()) {
//            int num = iterator.next();
//            if (num > 10) {
//                iterator.remove();
//            }
//        }
        // Удаляем числа больше 10 v2
        numbers.removeIf(i -> i >= 10);

        System.out.println("\nNumbers < 10:");
        for (int n : numbers) {
            System.out.println(n); // Выводим числа, не превышающие 10
        }

        scanner.close();
    }
}
