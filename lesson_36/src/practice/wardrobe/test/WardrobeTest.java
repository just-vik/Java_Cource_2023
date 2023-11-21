package practice.wardrobe.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.wardrobe.model.Wardrobe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WardrobeTest {
    private static final int SIZE = 10;
    private static final int MAX = 6;
    private static final int MIN = 1;
    static Random random = new Random();
    Wardrobe[] wardrobes;

    @BeforeEach
    void setUp() {
        // Создаем массив объектов Wardrobe
        wardrobes = new Wardrobe[SIZE];

        // Заполняем массив случайно сгенерированными объектами Wardrobe
        for (int i = 0; i < wardrobes.length; i++) {
            double height = MIN + random.nextInt(MAX);
            double width = MIN + random.nextInt(MAX);
            double depth = MIN + random.nextInt(MAX);
            wardrobes[i] = new Wardrobe(height, width, depth);
        }
    }

    // Метод для вывода содержимого массива на экран
    private void printArray(Object[] arr, String title) {
        System.out.println("=======" + title + "=======");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testNaturalOrderWardrobe() {
        // Выводим исходное содержимое массива до сортировки
        printArray(wardrobes, "Test Comparable before sort");

        // Сортируем массив объектов Wardrobe. Это предполагает, что класс Wardrobe
        // реализует интерфейс Comparable и определяет свой порядок сортировки.
        Arrays.sort(wardrobes);

        // Выводим содержимое массива после сортировки
        printArray(wardrobes, "Test Comparable after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(5, 4, 1));
        System.out.println("index = " + index);
    }

    @Test
    void testAreaComparator() {
        // Выводим исходное содержимое массива до сортировки
        printArray(wardrobes, "Test Area Comparator before sort");

        // Создаем компаратор для сравнения объектов Wardrobe по площади
        Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.area(), w2.area());

        // Сортируем массив объектов Wardrobe, используя компаратор, который сравнивает
        // объекты по их площади.
        Arrays.sort(wardrobes, comparator);

        // Выводим содержимое массива после сортировки
        printArray(wardrobes, "Test Area Comparator after sort");

        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }

    @Test
    void testVolumeComparator() {
        // Выводим исходное содержимое массива до сортировки
        printArray(wardrobes, "Test Volume Comparator before sort");

        // Создаем компаратор для сравнения объектов Wardrobe по площади
        Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.volume(), w2.volume());

        // Сортируем массив объектов Wardrobe, используя компаратор, который сравнивает
        // объекты по их площади.
        Arrays.sort(wardrobes, comparator);

        // Выводим содержимое массива после сортировки
        printArray(wardrobes, "Test Volume Comparator after sort");

        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }

    @Test
    void testHeightVolumeComparator() {
        printArray(wardrobes, "Test Height & Volume Comparator before sort");
        Comparator<Wardrobe> comparator = (w1, w2) -> {
            //int res=w1.compareTo(w2);
            int res = Double.compare(w1.getHeight(), w2.getHeight());
            return res != 0 ? res : Double.compare(w1.volume(), w2.volume());
        };
        Arrays.sort(wardrobes, comparator);
        printArray(wardrobes, "Test Height & Volume Comparator after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }

}