package homework.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNumsTest {

//    @BeforeEach
//    void setUp() {
//        arrayNums = new ArrayNums;
//    }

    @Test
    void evenNum() {
        int[] arr = {12, 11, -10, 13};
        assertEquals(1, ArrayNums.evenNum(arr), 0.01);
    }

}