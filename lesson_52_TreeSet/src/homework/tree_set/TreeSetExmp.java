package homework.tree_set;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetExmp {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        Random random = new Random();

        for (int i = 0; i <= 10; i++) {
            int randomNumber = random.nextInt(10);
            numbers.add(randomNumber);
        }

        System.out.println("TreeSet elements: " + numbers);
        numbers.removeFirst();
        System.out.println("Remove first number" + numbers);
        System.out.println("Размер TreeSet: " + numbers.size());
        System.out.println("TreeSet пустой? " + numbers.isEmpty());
        boolean removed = numbers.remove(5); // Удаляет число 5 из TreeSet
        System.out.println("Удалено 5? " + removed);
        System.out.println("TreeSet после удаления 5: " + numbers);
        boolean contains = numbers.contains(3); // Проверяет, существует ли число 3 в TreeSet
        System.out.println("TreeSet содержит 3? " + contains);
        System.out.println("Итерация через TreeSet:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        numbers.clear();
        System.out.println("TreeSet после очистки: " + numbers);
    }
}
