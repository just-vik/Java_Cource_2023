package Homework.sentensies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.sentencies.Sentence;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addition() {

        assertEquals(6, calculator.addition(3, 3));
        assertEquals(0, calculator.addition(0, 0));
        assertEquals(-6, calculator.addition(-3, -3));
    }

    @Test
    void subtraction() {

        assertEquals(3, calculator.subtraction(6, 3));
    }

    @Test
    void multiplication() {

        assertEquals(9, calculator.multiplication(3, 3));
    }

    @Test
    void division() {

        assertEquals(3, calculator.division(9, 3));
    }

    @Test
    void divRem() {

        assertEquals(3, calculator.divRem(15, 4));
    }
}