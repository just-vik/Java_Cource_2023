package practice.fibonacci;

public class FibonacciApp {
    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci(10);
        // TODO print all numbers, and calculate sum
        // 1,1,2,3,5,8,13,21
        // sum = 54
        int sum = 0;
        for (Integer num : fibonacci) {
            sum += num;
            System.out.println(num);
        }
        System.out.println("Sum = " + sum);
    }
}
