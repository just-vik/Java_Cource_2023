package homework.tree_set;

import java.util.TreeSet;

public class TreeSetExmp {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(14);
        numbers.add(7);
        numbers.add(29);
        numbers.add(2);
        numbers.add(10);
        numbers.add(5);
        numbers.add(3);
        numbers.add(50);
        numbers.add(18);
        numbers.add(16);

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
