package practice;

public class ArrayApplication {
    public static void main(String[] args) {
        int[] number = {8, 9, 12, 65, 98, 3, -20, 4, 1, 22};
        // берем метод для печати массива из класса ArrayMethods
        // !!! файл с методами должен находится в той же директории, что и ArrayMethods
        ArrayMethods.printArray(number);
        int max = ArrayMethods.maxArray(number);
        System.out.println("Maximum = " + max);
        int maxIndex = ArrayMethods.maxArrayIndex(number);
        System.out.println("Index of max element: " + maxIndex);
        ArrayMethods.sortArrayIntAsc(number);//выполняем сортировку от большего к меньшему
        ArrayMethods.printArray(number);//печатаем после сортировки
        ArrayMethods.split();


//        int[] number2 = {-5, 56, -100, 0, 15, 52, 67, 8, 1};
//        ArrayMethods.printArray(number2);
//        int max2 = ArrayMethods.maxArray(number2);
//        System.out.println("Maximum = " + max2);
//        int maxIndex2 = ArrayMethods.maxArrayIndex(number2);
//        System.out.println("Index of max element: " + maxIndex2);
//        ArrayMethods.sortArray(number2);//выполняем сортировку
//        ArrayMethods.printArray(number2);//печатаем после сортировки
//        ArrayMethods.split();
//
//
//        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        ArrayMethods.printArray(digits);


    }
}
