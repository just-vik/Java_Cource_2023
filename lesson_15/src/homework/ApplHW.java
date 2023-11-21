package homework;

public class ApplHW {
    public static void main(String[] args) {
        // Создаем массив из 20 случайных целых чисел от -100 до 100
        int[] array = MethodsHW.randomArray();
        int[] positiveNumbers = MethodsHW.positiveNumSearch(array);
        MethodsHW.printArray(array);
        MethodsHW.printArray(positiveNumbers);
        MethodsHW.split();
        // Сортируем массив
        MethodsHW.sortedSort(array);
        MethodsHW.printArray(array);

        int zeroIndx = MethodsHW.binarySearch(array, 0);
        //System.out.println("Index = " + zeroIndx);
        if (zeroIndx >= 0) { // -12(zeroIndx) >= 0 --> false
            System.out.println(0 + " presents in array, index = " + zeroIndx);
        } else {
            System.out.println(0 + " doesn't present in array, index for possible position is " + (-zeroIndx -1));
        }
    }
}
