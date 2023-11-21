package practice.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.soldier.model.Soldier;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    Integer[] arrNum;
    String[] arrStr;
    Soldier[] soldiers;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{3, 5, 7, 4, 6, 7, 9, 8};
        arrStr = new String[]{"one", "two", "three", "four", "five"};

        soldiers = new Soldier[]{
                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Rabindranate", 162, 55.1, 91),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88)
        };
    }


    @Test
    void testArraysSort() {
        System.out.println("==========testArraysSort==========");
//        Arrays.sort - использует timsort(quicksort) метод сортировки
        Arrays.sort(arrNum);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testArraysSortComparator() {
        System.out.println("==========testArraysSortComparator==========");
        Arrays.sort(arrNum, (n1, n2) -> n2 - n1);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testSortSoldiersNaturalOrder() {
        System.out.println("==========testSortSoldiersNaturalOrder==========");
//        int t = soldiers[3].compareTo(soldiers[1]);
        Arrays.sort(soldiers);
        printArray(soldiers);

    }

    @Test
    void testSortSoldiersByName() { //можно поменять метод compareTo
        //но можно более универсально с помощью comparator
        System.out.println("==========testSortSoldiersByName==========");
        Arrays.sort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByProfile() { //примитив (число) используем "-"
        System.out.println("==========testSortSoldiersByProfile==========");
        Arrays.sort(soldiers, (s1, s2) -> s2.getProfile() - s1.getProfile());
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByProfileAndByHeight() { //примитив используем "-"
        System.out.println("==========testSortSoldiersByProfileAndByHeight==========");
        // используем сложные тернарные операторы, в практике лучше не использовать, так как плохо читаем
        Arrays.sort(soldiers, (s1, s2) -> {
            int res = s1.getProfile() - s2.getProfile();
//            int res = -(s1.getProfile() - s2.getProfile()); //  - противоположное решение
            res = res != 0 ? res : s1.getHeight() - s2.getHeight();
            return res != 0 ? res : s1.getName().compareTo(s2.getName()); //если одинаковый профиль, то сравним по весу
        });
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByWeight() {
        System.out.println("==========testSortSoldiersByWeight==========");
//        Arrays.sort(soldiers, (s1, s2) -> (int) (s1.getWeight()-s2.getWeight()); при кастинге на инт дабл округляется и сортировка не корректна
//        Arrays.sort(soldiers, (s1, s2) -> {
//            double res =s1.getWeight()-s2.getWeight();
//            if (res<0) {
//                return -1;
//            }
//            if (res>0) {
//                return 1;
//            }
//            return 0;
//        });

        //В данном случае, компаратор представлен анонимной функцией (лямбда-выражением),
        // которая сравнивает два объекта Soldier на основе их веса. Она использует метод Double.compare
        // для сравнения значений веса.
        Arrays.sort(soldiers, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));

        // Этот метод позволяет создать компаратор, который сравнивает объекты на основе указанного свойства.
        Arrays.sort(soldiers, Comparator.comparingDouble(Soldier::getWeight));

        printArray(soldiers);
    }


    //    Домашнее задание от 34 урока
    //Напишите OddEvenComparator, реализующий Comparator с методом сравнения
    // для сортировки массива целых чисел в следующем порядке:
    // Четные целые числа должны идти перед нечетными числами.
    @Test
    void testOdEvenComparator1() {
        Integer[] origin = {1, 4, 3, 2, 5, 6, 9, 8, 7, 3};
        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            return 0;
        };
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.toString(origin));
    }

    //    Четные целые числа должны идти перед нечетными числами в порядке возрастания.
//    Нечетные целые числа должны идти после четных в порядке убывания
    @Test
    void testOdEvenComparator2() {
        // Создаем массив целых чисел и инициализируем его данными
        Integer[] origin = {1, 4, 3, 2, 5, 6, 9, 8, 7, 3};

        // Создаем компаратор для определения порядка сортировки
        Comparator<Integer> comparator = (n1, n2) -> {
            // Если n1 четное и n2 нечетное, считаем n1 "меньшим"
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            // Если n1 нечетное и n2 четное, считаем n2 "меньшим"
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            // Если оба числа четные, сортируем их по возрастанию
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1 - n2;
            }
            // Если оба числа нечетные, сортируем их по возрастанию
            if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2 - n1;
            }
            // Если числа равны, возвращаем 0
            return 0;
        };

//Альтернативный код более логичный, но менее понятный для разбора
//            if (n % 2 == 0) {
//            return 0; // Четные числа имеют приоритет 0
//        } else {
//            return 1; // Нечетные числа имеют приоритет 1
//        }
//    }).thenComparing(Integer::intValue); // Затем сортируем по значению

//  thenComparing используется для дополнительной сортировки по значению самих чисел.
//  Это гарантирует, что числа будут упорядочены правильным образом как внутри четных,
//  так и внутри нечетных чисел.

        // Сортируем массив с использованием компаратора
        Arrays.sort(origin, comparator);

        // Выводим отсортированный массив на экран
        System.out.println(Arrays.toString(origin));
    }



    public void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===============================================");
    }
}
