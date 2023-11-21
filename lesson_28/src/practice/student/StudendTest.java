package practice.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudendTest {
    Studend studend;

    @BeforeEach
    void setUp() {
        studend = new Studend();
    }

    @Test
    @DisplayName("Тест расчета среднего балла")
    void averageMark() {
        int[] marks = {1, 2, 1, 3, 2, 1, 6, 5, 4, 2};
        assertEquals(2.7, studend.averageMark(marks));
    }
}