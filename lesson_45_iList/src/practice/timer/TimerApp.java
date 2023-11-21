package practice.timer;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TimerApp {
    public static void main(String[] args) {
        Timer time = new TimerImpl();

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Укажите время таймера в секундах:");
//        int timerTime = scanner.nextInt();
//
//        time.startTimer(timerTime);

//        long stopWatchResult = time.stopWatch(scanner);
//        System.out.println(stopWatchResult);

//        LocalTime stopWatchResult = time.stopWatchInTime(scanner);
//        System.out.println(stopWatchResult);

        System.out.println("Enter year:");
        int year = scanner.nextInt();
        System.out.println("Enter month:");
        int month = scanner.nextInt();
        System.out.println("Enter day:");
        int day = scanner.nextInt();
        System.out.println("Enter hour:");
        int hour = scanner.nextInt();
        System.out.println("Enter min:");
        int min = scanner.nextInt();

        LocalDateTime timeToWakeUp = LocalDateTime.of(year, month, day, hour, min);
        time.alarm(timeToWakeUp);

    }
}
