package homework;

import java.util.Scanner;

// Вводится n - натуральное число.
// Напишите метод, который получает на вход n и вычисляет n! = 1 * 2 * 3 *... * n.
// Вызовите полученный метод.
// При каком значении n происходит переполнение памяти,
// выделяемой для n типа int? Использовать цикл for.
public class OverMemory {
    public static void main(String[] args) {
        //задаем значение n
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input value n: ");
        int n = scanner.nextInt();
        //вызываем метод
        long res = calcOverflowMemory(n);
        if (res == -1) {
            System.out.println("Memory overflow for n= " + n);
        } else {
            System.out.println(n + "! = " + res);
        }
    }// =========== end of main ============
    // ============= methods ===============
    public static long calcOverflowMemory(int n) {
        int memory = 1;//создаем переменную типа long
        for (int i = 1; i < n; i++) {
            memory *= i;
            if (memory < 0) {
                return -i;
            }
        }
        return memory;
    }
}
