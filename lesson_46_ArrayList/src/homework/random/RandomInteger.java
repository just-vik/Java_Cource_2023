package homework.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomInteger {
    public static void main(String[] args) {
        // создаем ArrayList типа <Integer> и заполняем его 20 случайными числами в диапазоне от 1 до 10 с помощью цикла fori.
        List<Integer> randomIntegers = new ArrayList<>();
        // Класс Random используем для генерации случайных чисел в диапазоне от 1 до 10.
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomIntegers.add(random.nextInt(10) + 1);
        }
        System.out.println(randomIntegers + " <== Случайные числа");

        // Создаём HashSet из ArrayList, чтобы удалить дубликаты.
        HashSet<Integer> uniqueIntegers = new HashSet<>(randomIntegers);
        // HashSet затем используем для создания нового ArrayList уникальных чисел.
        ArrayList<Integer> uniqueRandomIntegers = new ArrayList<>(uniqueIntegers);

        System.out.println(uniqueRandomIntegers + " <== Уникальные случайные числа (БЕЗ ДУБЛИКАТОВ)");



        // создаем ArrayList типа <Integer> и заполняем его 20 случайными числами в диапазоне от 1 до 10 с помощью цикла fori.
        List<Integer> randomIntegers2 = new ArrayList<>();
        // Класс Random используем для генерации случайных чисел в диапазоне от 1 до 10.
        Random random2 = new Random();
        for (int i = 0; i < 20; i++) {
            randomIntegers2.add(random2.nextInt(10) + 1);
        }
        System.out.println(randomIntegers2 + " <== Случайные числа");
        List<Integer> uniqueIntegers2 = new ArrayList<>(); // создаём новый список для уникальных элементов
        for (Integer element : randomIntegers2) { // Проходимся в цикле по всем элементам списка randomIntegers
            if (!uniqueIntegers2.contains(element)) { // Если этот элемент отсутствует в uniqueIntegers
                uniqueIntegers2.add(element); // Тогда добавим его
            }
        }
        System.out.println(uniqueIntegers2 + " <== Уникальные случайные числа (БЕЗ ДУБЛИКАТОВ)");
    }
}

