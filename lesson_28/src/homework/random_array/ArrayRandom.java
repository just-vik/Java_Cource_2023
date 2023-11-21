package homework.random_array;


public class ArrayRandom {

    public  int[] RandomArray(int size) {
        int[] array = new int[size];
        int a = -10;
        int b = 10;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        //напечатаем полученный массив
        for (int j : array) {
            System.out.print(j + " ");
        }
        return array;
    }

    public static int positiveNum(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

    public static int negativeNum(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num < 0) {
                count++;
            }
        }
        return count;
    }

    public static int evenNum(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int zero(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }

}
