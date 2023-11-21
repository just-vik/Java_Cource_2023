package homework;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] n1 = ArrayMeth.randomArray();
        int[] n2 = ArrayMeth.randomArray();
        ArrayMeth.printArray(n1);
        ArrayMeth.printArray(n2);
        System.out.print("Sort methods: \n1.Min---->Max;\n2.Max---->Min  ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInput your choice(1 or 2):  ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            ArrayMeth.minMax(n1);
            ArrayMeth.minMax(n2);
            ArrayMeth.printArray(n1);
            ArrayMeth.printArray(n2);
        } else if (choice == 2) {
            ArrayMeth.maxMin(n1);
            ArrayMeth.maxMin(n2);
            ArrayMeth.printArray(n1);
            ArrayMeth.printArray(n2);
        } else {
            System.out.println("wrong choice");
        }

        System.out.println("Bubble Sort: ");
        int[] m1 = ArrayMeth.randomArray();
        int[] m2 = ArrayMeth.randomArray();
        ArrayMeth.printArray(m1);
        ArrayMeth.printArray(m2);
        ArrayMeth.split();
        ArrayMeth.bubbleSort(m1);
        ArrayMeth.printArray(m1);
        ArrayMeth.bubbleSort(m2);
        ArrayMeth.printArray(m2);
    }
}

