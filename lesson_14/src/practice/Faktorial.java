package practice;

// Вводится n - натуральное число.
// Напишите метод, который получает на вход n и
// вычисляет n! = 1 * 2 * 3 *... * n.
// Вызовите полученный метод.
// При каком значении n происходит переполнение памяти,
// выделяемой для n типа int?
// Использовать цикл for.
public class Faktorial {
    public static void main(String[] args) {

        int n = 31;
        int f = faktorial(n);
        System.out.println("Faktorial " + n + " = " + f);
    }

    public static int faktorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
           // if (f<0);
           // System.out.println(f отрицательно);
            f = f * i;
        }
        return f;
    }
}
