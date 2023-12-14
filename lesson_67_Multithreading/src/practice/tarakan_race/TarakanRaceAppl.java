package practice.tarakan_race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDateTime;

public class TarakanRaceAppl {
    public static void main(String[] args) throws IOException {
//вместо Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input number of tarakans: ");
        int nTarakans = Integer.parseInt(br.readLine());//ссчитать до нажатия ввода
        System.out.println("Input distance: ");
        int distance = Integer.parseInt(br.readLine());
        Tarakan.setDistance(distance);//всем тараканам назначили дистанцию

        Thread[] tarakans = startRace(nTarakans);//старт гонки
        waitFinish(tarakans);//все потоки присоединились к main
        System.out.printf("Congratulation to the Winner " + Tarakan.getWinner());
    }


    private static Thread[] startRace(int nTarakans) {
        Thread[] threads = new Thread[nTarakans];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Tarakan("Tarakan # " + (i + 1)));//новый тред которому передали процесс
            // на базе Runnable класса
        }
        //запускаем треды
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return threads;
    }

    private static void waitFinish(Thread[] tarakans) {
        for (int i = 0; i < tarakans.length; i++) {
            try {
                tarakans[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
