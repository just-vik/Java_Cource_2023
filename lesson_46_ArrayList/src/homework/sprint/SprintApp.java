package homework.sprint;


import java.util.*;

public class SprintApp {
    public static void main(String[] args) {
        List<Athletes> athlete = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Enter result for Athlete " + i + ":");
//            double addResult = scanner.nextDouble();

            athlete.add(new Athletes(1276, "John", "Doe", "ClubA", 10.2));
            athlete.add(new Athletes(1109, "Alice", "Smith", "ClubB", 9.8));
            athlete.add(new Athletes(1067, "Bob", "Johnson", "ClubC", 10.5));
            athlete.add(new Athletes(1477, "Eva", "Brown", "ClubD", 10.0));
            athlete.add(new Athletes(1467, "Mike", "Williams", "ClubE", 9.5));
            athlete.add(new Athletes(1723, "Sophia", "Jones", "ClubF", 10.3));
            athlete.add(new Athletes(1371, "David", "Miller", "ClubG", 9.9));
            athlete.add(new Athletes(1945, "Emma", "Davis", "ClubH", 10.1));
            athlete.add(new Athletes(1566, "Chris", "Clark", "ClubI", 10.4));
            athlete.add(new Athletes(1649, "Olivia", "Anderson", "ClubJ", 10.5));



            System.out.println("\u001B[1mRESULTS: \u001B[0m");
            Collections.sort(athlete, Comparator.comparing(Athletes::getResult)); //сортировка элементов по результату
            for (Athletes athletes : athlete) {
                System.out.println(athletes);
            }
            // Объявление победителя
            Athletes win = athlete.get(0);
            System.out.println("\u001B[32m\u001B[1mWINNER: " + win.getFirstName() + " " + win.getLastName() +
                    " with result " + win.getResult() + " sec.\u001B[0m");
    }
}

