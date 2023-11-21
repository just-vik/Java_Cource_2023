package practice.city.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.city.model.City;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CityTest {
    City[] cities;

    @BeforeEach
    void setUp() {
        System.out.println("SetUp");
        cities = new City[6];
        cities[0] = new City("Denver", 600_000);
        cities[1] = new City("Boston", 670_000);
        cities[2] = new City("Chicago", 2_700_000);
        cities[3] = new City("Atlanta", 470_000);
        cities[4] = new City("New York", 8_500_000);
        cities[5] = new City("Dallas", 1_300_000);

    }

    private void printArray(Object[] arr, String title) {
        System.out.println("==========" + title + "==========");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testIntegerDesc() {
// Мы создали два массива с числами: actual и expected.
// actual содержит числа -1, самое маленькое целое число и самое большое целое число.
// expected содержит самое большое целое число, -1 и самое маленькое целое число.

        Integer[] actual = {-1, Integer.MIN_VALUE, Integer.MAX_VALUE};
        Integer[] expected = {Integer.MAX_VALUE, -1, Integer.MIN_VALUE};

// Теперь мы собираемся отсортировать массив actual так, чтобы числа были в порядке убывания.
// Для этого мы используем функцию сравнения (n1, n2) -> Integer.compare(n2,n1).
// Эта функция сравнивает два числа n1 и n2 и говорит, какое из них должно идти первым при сортировке.
// Так как мы хотим сортировать по убыванию, мы говорим, что большие числа идут первыми.
// Теперь мы сортируем массив actual в соответствии с этой функцией сравнения.

        Arrays.sort(actual, (n1, n2) -> Integer.compare(n2, n1));

// Теперь, когда массив actual отсортирован, мы сравниваем его с массивом expected.
// Мы ожидаем, что actual будет иметь тот же порядок чисел, что и expected после сортировки.
// Поэтому мы используем assertArrayEquals, чтобы убедиться, что они действительно одинаковы.

        assertArrayEquals(expected, actual);
    }

    @Test
    void testCityComparable() {
        printArray(cities, "Original array");
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City pattern = new City("Chicago", 2_700_000);
        int index = Arrays.binarySearch(cities, pattern);
        System.out.println("Index = " + index);
    }

    @Test
    void testCityNameComparator() {
        Comparator<City> comparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
        Arrays.sort(cities, comparator);
        printArray(cities, "Sort by name");
        City pattern = new City("Chicago", 0);
        int index = Arrays.binarySearch(cities, pattern, comparator);
        System.out.println("Index = " + index);
    }

    @Test
    void testArrayCopy() {
// Мы создаем компаратор, который поможет нам сравнивать объекты типа City по их именам.
        Comparator<City> comparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
        City[] citiesCopy = Arrays.copyOf(cities, cities.length * 2);

// Мы копируем элементы из массива cities в массив citiesCopy, чтобы у нас была точная копия перед сортировкой.
//        City[] citiesCopy = new City[cities.length];
//        for (int i = 0; i < citiesCopy.length; i++) {
//            citiesCopy[i] = cities[i];
//        }
// Мы выводим в консоль содержимое массива citiesCopy перед сортировкой.
        printArray(citiesCopy, "Cities copy before sort");

        Arrays.sort(citiesCopy, 0, cities.length, comparator); //0,cities.length,
// Мы выводим в консоль содержимое массива citiesCopy после сортировки.
        printArray(citiesCopy, "Cities copy after sort");
        City pattern = new City("Yalta", 0);
        int index = Arrays.binarySearch(citiesCopy, 0, cities.length, pattern, comparator);
        System.out.println("Index = " + index);
    }

    @Test
    void testCopyOfRange() {
        City[] citiesCopy = Arrays.copyOfRange(cities, 1, cities.length - 1);
        printArray(citiesCopy, "Copy of range");
    }

    @Test
    void testSystemArrayCopy() {
        City[] citiesCopy = new City[cities.length * 2];
        System.arraycopy(cities, 1, citiesCopy, 4, 4);
        printArray(citiesCopy, "System.arrayCopy");
    }

    @Test
    void testKeepSorted() {
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City city = new City("Salem", 690_000);
        City[] citiesCopy = Arrays.copyOf(cities, cities.length + 1);
//        Wrong away
//        citiesCopy[citiesCopy.length - 1] = city;
//        Arrays.sort(citiesCopy);
        //найти место
        int index = Arrays.binarySearch(citiesCopy, 0, citiesCopy.length - 1, city);
        index = index >= 0 ? index : -index - 1;
        //сдвигаем массив
        System.arraycopy(citiesCopy, index, citiesCopy, index + 1, citiesCopy.length - index - 1);
        // вставить новый элемент
        citiesCopy[index] = city;
        cities = citiesCopy;
        printArray(cities, "Natural order after add new city");
    }
}

