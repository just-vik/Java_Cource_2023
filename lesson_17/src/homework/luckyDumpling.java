package homework;

import java.util.Random;

public class luckyDumpling {
    public static void main(String[] args) {
        Random random = new Random(); // генератор случайных чисел

        int[] dumpling = new int[30];
        int luckyDumpIndex = random.nextInt(30); // генерирует cлучайный индекс на месте которого будет элемент "счастливый пельмень"

        for (int i = 0; i < 30; i++) {
            dumpling[i] = random.nextInt(11) + 25; // генерирует случайное целое число от 0 до 10(11) +25(создаем диапазон от 25 до 35)
        }
        dumpling[luckyDumpIndex] = dumpling[luckyDumpIndex] + 15; //добавляет 15 к выбранному "пельменю"

        for (int i = 0; i < 30; i++) { //перебираем элементы массива
            if (i == luckyDumpIndex) { //условие, с помощью которого включаем выделение красным цветом(ANSI коды)
                System.out.print("\u001B[32m");
            }
            System.out.println("Dumpling " + (i + 1) + " : " + dumpling[i] + " grams");
            if (i == luckyDumpIndex) { //условие при котором выключаем выделение цветом(чтобы подсвечивало только выбранное значение, а не все оставшиеся после него)
                System.out.print("         ⬆\uFE0F\uD83E\uDD5FLucky Dumpling\n" + "\u001B[0m");
            }
        }
        System.out.println("Lucky dumpling is " + (luckyDumpIndex + 1));
    }
}


