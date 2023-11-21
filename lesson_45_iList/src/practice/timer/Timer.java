package practice.timer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public interface Timer {
    void startTimer(long seconds);

    long stopWatch(Scanner scanner);

    LocalTime stopWatchInTime(Scanner scanner);

    void alarm(LocalDateTime timeToWakeUp);

    void pomidoroTimer();
}
