package homework;

import java.util.Scanner;

// В первый день спортсмен пробежал s километров,
// а затем он каждый день увеличивал пробег на 10 % от предыдущего значения.
// Определите номер того дня, на который пробег спортсмена составит не менее target километров.
// Программа получает на вход действительные числа s и target
// и должна вывести одно натуральное число.
public class Running {
    @SuppressWarnings("LoopConditionNotUpdatedInsideLoop")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the distance you run per day: ");
        double s = scanner.nextInt();
        System.out.println("Input the target: ");
        double target = scanner.nextInt();

        // day 2 = day 1 + day1 * 0.1

        int count = 1;

        while (s <= target) {
            s = s + s * 0.1;
            count++;
        }
        System.out.println("On " + count + " day you'll reach target: " + s + " км");
    }
}
