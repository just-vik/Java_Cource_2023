package homework;

import arrays.utils.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenComparatorTest {
    Integer[] arrNum;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{3, 5, 2, 4, 6, 7, 9, 8};
    }

    @Test
    void testCompare() {
        System.out.println("==========testOddEvenComparator==========");
        ArrayTools.evenOddComparator(arrNum,new OddEvenComparator());
        ArrayTools.printArray(arrNum);

    }
}