package Homework.sentensies;

public class Calculator {
    public int addition(int a, int b) {
        return a + b;
    }
    public int subtraction(int a, int b) {
        return a - b;
    }
    public int multiplication(int a, int b) {
        return a * b;
    }
    public int division(int a, int b) {
        return a / b;
    }
    public int divRem(int a, int b) {
        int div = a / b;
        int rem = a % b;
        return rem;
    }
}