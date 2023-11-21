package practice.timer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class TimerImpl implements Timer{
    public void startTimer(long seconds) {
        LocalTime now = LocalTime.now();
        LocalTime endTime = now.plusSeconds(seconds);

        System.out.println("Starts at: " + now);
        System.out.println();

        while (!now.isAfter(endTime)) {
            now = LocalTime.now();
//            System.out.println("Current time: " + now);
            System.out.println("Seconds left: " + seconds--);
            sleep(1000);
        }

        System.out.println();
        System.out.println("End: " + now);
    }

    @Override
    public long stopWatch(Scanner scanner) {
        System.out.println("Push enter to start stopwatch");
        scanner.nextLine();
        long startTime = System.currentTimeMillis();

        System.out.println("Push enter to end stopwatch");
        scanner.nextLine();
        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000;
    }

    @Override
    public LocalTime stopWatchInTime(Scanner scanner) {
        System.out.println("Push enter to start stopwatch");
        scanner.nextLine();
        LocalTime startTime = LocalTime.now();

        System.out.println("Push enter to end stopwatch");
        scanner.nextLine();
        LocalTime endTime = LocalTime.now();

//        LocalTime different = endTime
//                .minusHours(startTime.getHour())
//                .minusMinutes(startTime.getMinute())
//                .minusSeconds(startTime.getSecond())
//                .minusNanos(startTime.getNano());
//
//        return different;

        return endTime
                .minusHours(startTime.getHour())
                .minusMinutes(startTime.getMinute())
                .minusSeconds(startTime.getSecond())
                .minusNanos(startTime.getNano());
    }


    @Override
    public void alarm(LocalDateTime timeToWakeUp) {
        while (LocalDateTime.now().compareTo(timeToWakeUp) < 0) {
            sleep(1000);
        }

//        while (LocalDateTime.now().isBefore(timeToWakeUp)) {
//            sleep(1000);
//        }

        System.out.println("Time to wake up, now is: " + LocalDateTime.now());
    }

    @Override
    public void pomidoroTimer() {

    }

    public static void sleep(long sleepDurationInMs) {
        try {
            Thread.sleep(sleepDurationInMs);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
