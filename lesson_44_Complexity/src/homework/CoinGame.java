package homework;

import java.util.Random;
import java.util.Scanner;

public class CoinGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ввод выбора от первого пользователя
        System.out.print("Игрок 1, выберите орла ('o') или решку ('р'): ");
        char player1Choice = scanner.next().charAt(0);

        // Ввод выбора от второго пользователя
        System.out.print("Игрок 2, выберите орла ('o') или решку ('р'): ");
        char player2Choice = scanner.next().charAt(0);

        // Генерация случайного результата (орел или решка)
        char coinResult = (random.nextInt(2) == 0) ? 'o' : 'р';

        // Вывод результата
        System.out.println("Монета падает...");

        // Пауза для эффекта ожидания
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println();

        System.out.println("Результат: " + coinResult);

        // Проверка победителя
        if ((player1Choice == coinResult) && (player2Choice != coinResult)) {
            System.out.println("Игрок 1 выиграл!");
        } else if ((player2Choice == coinResult) && (player1Choice != coinResult)) {
            System.out.println("Игрок 2 выиграл!");
        } else if ((player1Choice == coinResult) && (player2Choice == coinResult)) {
            System.out.println("Ничья! Оба игрока выбрали правильно.");
        } else {
            System.out.println("Никто не выиграл. Оба игрока проиграли.");
        }
    }
}
