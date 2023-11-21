package homework.array_students;

import java.util.Arrays;
import java.util.Random;

public class Students {
    public static void main(String[] args) {
        //задаем массив студентов
        String[] students = {"John", "Adam", "Michael", "Oliver", "Susan", "Mary", "Agata", "Zoya"};
        // создаем random для генерации случайных чисел
        Random random = new Random();
        // перемешиваем студентов c помощью random
//      for (int i = students.length - 1; i > 0; i--) { // на каждой итерации i уменьшается на 1
        for (int i = 0; i < students.length; i++) {
            int index = random.nextInt(i + 1); // генерирует случайное число в диапазоне от 0 (включительно) до i + 1
            // меняем элементы местами
            String temp = students[i];
            students[i] = students[index];
            students[index] = temp;
        }

        // разделяем на 2 массива
        // копируем часть массива с 0 индекса до половины длинны
        String[] arr1 = Arrays.copyOfRange(students, 0, students.length / 2);
        // копируем другую часть массива с половины его длинны до конечного индекса
        String[] arr2 = Arrays.copyOfRange(students, students.length / 2, students.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
