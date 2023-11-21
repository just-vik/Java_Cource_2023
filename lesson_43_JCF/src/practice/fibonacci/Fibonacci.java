package practice.fibonacci;

import practice.fibonacci.model.FibonacciIterator;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer>{ //числа фибоначи все целые поэтому используем Integer

    private int qty; //кол-во чисел в последовательности

    public Fibonacci(int qty) {
        this.qty = qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(qty);
    }
}
