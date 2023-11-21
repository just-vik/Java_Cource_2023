package homework.land_name;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LandNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter qty names of lands in Germany: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        //создаем Set для хранения введенных названий
        Set<String> landNames = new HashSet<>();

        //с помощью цикла добавляем названия земель в массив
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter land name: " + i);
            String landName = scanner.nextLine();
            landNames.add(landName);
        }

        System.out.println("\nList of land names in Germany:");
        for (String name : landNames) {
            System.out.println(name);
        }
        scanner.close();
    }
}
