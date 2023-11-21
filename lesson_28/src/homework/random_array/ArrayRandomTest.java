package homework.random_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRandomTest {

    private int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{5, 8, 1, -3, -7, 4, 0, -1, 0};
    }

    @Test
    void positiveNum() {
        int res= ArrayRandom.positiveNum(array);
        assertEquals(4, res);
    }

    @Test
    void negativeNum() {
        int res = ArrayRandom.negativeNum(array);
        assertEquals(3, res);
    }

    @Test
    void evenNum() {
        int res = ArrayRandom.evenNum(array);
        assertEquals(4, res);
    }

    @Test
    void zero() {
        int res = ArrayRandom.zero(array);
        assertEquals(2, res);
    }
}