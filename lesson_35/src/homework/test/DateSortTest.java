package homework.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
//            //разбиваем строки, убираем "-"
//            String[] p1 = s1.split("-");
//            String[] p2 = s2.split("-");
//            // извлекаем день, месяц, год из массива (parseInt)
//            int d1 = Integer.parseInt(p1[0]);
//            int d2 = Integer.parseInt(p2[0]);
//            int m1 = Integer.parseInt(p1[1]);
//            int m2 = Integer.parseInt(p2[1]);
//            int y1 = Integer.parseInt(p1[2]);
//            int y2 = Integer.parseInt(p2[2]);
//            // года не равны
//            if (y1 != y2) {
//                // Сравниваем годы
//                return Integer.compare(y1, y2);
//            }
//            // года равны, месяца не равны
//            if (m1 != m2) {
//                // Сравниваем месяцы
//                return Integer.compare(m1, m2);
//            }
//            //года и месяца равны, сравниваем дни
//            return Integer.compare(d1, d2);
//        };

            String[] arr1 = s1.split("-");
            String[] arr2 = s2.split("-");
            for (int i = arr1.length - 1; i >= 0; i--) {
                int d1 = Integer.parseInt(arr1[i]);
                int d2 = Integer.parseInt(arr2[i]);
                if (d1 > d2) {
                    return 1;
                }
                if (d1 < d2) {
                    return -1;
                }
            }
            return 0;
        };
    }

    @Test
    void testDateSort() {
        System.out.println("===============testDateSort==============");
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970",
        };
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010",
        };
        Arrays.sort(dates, comparator);
        assertArrayEquals(expected, dates);
        printArray(dates);
    }


    public void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("======================================");
    }
}
