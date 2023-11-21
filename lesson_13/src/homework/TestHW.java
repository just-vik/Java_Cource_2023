package homework;

public class TestHW {
        public static void main(String[] args) {
            int[] number = ArrayMethodsHW.randomArray();             //метод запрашивает количество элементов для рандомного подбора в диапазоне -100......100
            ArrayMethodsHW.printArray(number);                       //метод печатает элементы по заданному массиву
            int min = ArrayMethodsHW.minArray(number);               //метод находит минимальное значение
            System.out.println("Minimum = " + min);                  //метод печатает найденное минимальное значение
            int minIndex = ArrayMethodsHW.minArrayIndex(number);     //метод находит индекс минимального значения
            System.out.println("Index of min element: " + minIndex); //метод печатает индекс
            System.out.println();
            ArrayMethodsHW.sortArrayIntAsc(number);                  //метод сортирует массив от большего к меньшему
            ArrayMethodsHW.printArray(number);                       //метод печатает элементы отсортированного массива
            System.out.println(" After much agony: \uD83C\uDF89  \uD83D\uDC86");
        }
    }

