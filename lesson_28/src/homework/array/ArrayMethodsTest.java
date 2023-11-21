package homework.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {
    ArrayMethods arrayMethods;

    @BeforeEach
    void setUp() {
        arrayMethods = new ArrayMethods();
    }

    @Test
    void sum() {
        int[] array = {2, 5, 3, 6, 4, 8, 3, 8, 9};
        int res = arrayMethods.sum(array);
        assertEquals(48, res);
    }

    @Test
    void elementLocate() {
        int[] array = {2, 5, 3, 6, 4, 8, 3, 8, 9};
        boolean res = arrayMethods.elementSearch(array, 5);
        assertTrue(res);
    }

    @Test
    void elementNotLocate() {
        int[] array = {2, 5, 3, 6, 4, 8, 3, 8, 9};
        boolean res = arrayMethods.elementSearch(array, 1);
        assertFalse(res);
    }
}