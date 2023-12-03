package practice.collections;

import java.util.*;

public class CollectionsMethods {
    public static void main(String[] args) {
// Создайте список известных вам фруктов.
// Выполните поиск имеющегося и отсутствующего элемента списка.
// Отсортируйте этот список по алфавиту в прямом и обратном порядке.
// Проверьте работу методов
// max(Collection<?> coll)
// min(Collection<?> coll), что они возвращают?

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("pear");
        fruits.add("plum");
        fruits.add("strawberry");

        System.out.println("----------------------------");
        print(fruits);
        System.out.println("----------------------------");

        Collections.sort(fruits);//сделали сортировку

        System.out.println("----------------------------");
        print(fruits);
        System.out.println("----------------------------");

        String key = "banana";
        int index = Collections.binarySearch(fruits, key);
        System.out.println("Index = " + index + " of " + key);
        //ищем отсутствующий элемент
        key = "kiwi";
        index = Collections.binarySearch(fruits, key);
        System.out.println("Index = " + index + " of " + key);


        System.out.println("=====Отсортируйте этот список по алфавиту в прямом и обратном порядке======");
        Comparator<String> fComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);//знак "-" сортировка в обратном порядке
            }
        };
        Collections.sort(fruits, fComparator);
        System.out.println("----------------------------");
        print(fruits);
        System.out.println("----------------------------");

        System.out.println("=====min(Collection<?> coll)/max(Collection<?> coll)======");
        String max = Collections.max(fruits);
        System.out.println("Max of = " + max);
        String min = Collections.min(fruits);
        System.out.println("Min of = " + min);

        Collections.reverse(fruits);
        System.out.println("----------------------------");
        print(fruits);
        System.out.println("----------------------------");
        max = Collections.max(fruits);
        System.out.println("Max of = " + max);
        min = Collections.min(fruits);
        System.out.println("Min of = " + min);
    }

    private static void print(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
