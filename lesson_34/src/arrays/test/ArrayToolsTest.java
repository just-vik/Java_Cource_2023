package arrays.test;

import arrays.utils.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {
    Integer[] arrNum;
    String[] arrStr;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{3, 5, 2, 4, 6, 7, 9, 8};
        arrStr = new String[]{"one", "two", "three", "four", "five"};
    }

    @Test
    void testPrintArray() {
        System.out.println("==========testPrintArray==========");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testSearch() {
        System.out.println("==========testSearch==========");
        int index = ArrayTools.search(arrStr, "four");
        System.out.println("Index = " + index);
        index = ArrayTools.search(arrStr, "six");
        System.out.println("Index = " + index);
        index = ArrayTools.<Integer>search(arrNum, 4); //<Integer> указываем на работу только с интеджер
        System.out.println("Index = " + index);
        index = ArrayTools.search(arrNum, 6);
        System.out.println("Index = " + index);
    }

    @Test
    void testFindByPredicate() {
        System.out.println("==========testFindByPredicate==========");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n<5;
            }
        };
        //Predicate<Integer> predicate = n -> n < 5;
        // predicate n меньше 5
        Integer num = ArrayTools.findByPredicate(arrNum, predicate); //n -> n < 5 лямбда выражения(функциональное программирование)
        System.out.println(num);

        num = ArrayTools.findByPredicate(arrNum, n -> n % 5 == 0);
        System.out.println(num);
        String str = ArrayTools.findByPredicate(arrStr, s -> s.length() == 4);// лямбда выражение как функция
        System.out.println(str);
    }

    @Test
    void testBubbleSortComparable() {
        System.out.println("==========testBubbleSortComparable==========");
        ArrayTools.bubbleSort(arrNum);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testBubbleSortComparator() {
        System.out.println("==========testBubbleSortComparator==========");
        ArrayTools.bubbleSort(arrNum, (n1, n2) -> n2 - n1);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr, (s1, s2) -> s1.length() - s2.length());
        ArrayTools.printArray(arrStr);
    }


}