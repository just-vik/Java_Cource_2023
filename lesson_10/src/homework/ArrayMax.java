package homework;

//Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38.
//Найдите максимальный элемент массива и его индекс.
public class ArrayMax {
    public static void main(String[] args) {
        int[] arrayMax = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};

        int max = arrayMax[0]; //объявляем переменную и присваиваем 1 значение
        int maxInx = 0; //переменная значения максимума

        for (int i = 0; i < arrayMax.length; i++) {
            if (arrayMax[i] > max) { // если значение больше переменной
                max = arrayMax[i]; //переопределяем значение max
                maxInx = i; // индекс максимума
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Index: " + maxInx);
    }
}

