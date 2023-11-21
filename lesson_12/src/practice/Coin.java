package practice;

//Подбросьте монетку 100 раз. Сколько раз выпала решка? Сколько орел?
//Сравните итоговые вероятности выпадения орла и решки.
public class Coin {
    public static void main(String[] args) {

        //Запустим цикл на 100 раз, щт датчика случайных чисел получим 0 или 1
        //запишем результаты "бросков" в массив

        int[] coin = new int[100];
        int a = 0;
        int b = 1;

        //заполняем массив
        for (int i = 0; i < coin.length; i++) {
            coin[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        //печатаем массив
        printArray(coin);
        //считаем значения орла и решки (avers и revers)
        int avers = 0;
        int revers = 0;
        for (int i = 0; i < coin.length; i++) {
            if (coin[i] == 0) {
                avers++;  //значение avers будем считать 0
            } else { //иначе количество revers
                revers++;
            }
        }
        System.out.println("Avers = " + avers + " " + (double) avers / 100);
        System.out.println("Revers = " + revers + " " + (double) revers / 100);
    }

    //================= methods ========================
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
