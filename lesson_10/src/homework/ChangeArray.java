package homework;

//Создайте массив из 20 целых чисел в интервале от 10 до 30. Выведите массив на печать.
//Поменяйте местами первый и последний элементы массива и снова выведите массив на печать.
public class ChangeArray {
    public static void main(String[] args) {
        int[] arrayNum = new int[30];

        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = 10 + i;
            System.out.print(arrayNum[i] + "| ");
        }


        int var = arrayNum[0]; // сохранитб значение 1 элемента с индексом 9
        arrayNum[0] = arrayNum[arrayNum.length - 1];
        arrayNum[arrayNum.length - 1] = var;

        System.out.println();

        for (int i = 0; i < arrayNum.length; i++) { //печать массива с изменениями
            System.out.print(arrayNum[i] + "| ");
        }


//        int[] array = new int[21];
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = 10 + i;
//            System.out.print(array[i] + " ");
//        }
//
//        int temp = array[0];
//        array[0] = array[array.length - 1];
//        array[array.length - 1 ] = temp;
//
//        System.out.println(); // переход на новую строку
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
    }
}



