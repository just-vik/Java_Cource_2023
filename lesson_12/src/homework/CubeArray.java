package homework;

//Бросьте кубик с 6-ю гранями 20 раз.
//Подсчитайте, сколько раз выпала каждая цифра.
public class CubeArray {
    public static void main(String[] args) {

        //Запустим цикл на 20 раз,  датчика случайных чисел получим 0, 1, 2, 3, 4, 5, 6
        int[] cubeArray = new int[20];
        //переменная для датчика случайных чисел от a(1) до b(6)
        int a = 1;
        int b = 6;

        //заполняем массив бросками кубика
        for (int i = 0; i < cubeArray.length; i++) {
            cubeArray[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        //вызвал метод для печати
        printArray(cubeArray);
        int side1 = 0;
        int side2 = 0;
        int side3 = 0;
        int side4 = 0;
        int side5 = 0;
        int side6 = 0;
        //перебираем результаты бросков
        for (int i = 0; i < cubeArray.length; i++) {
            int move = cubeArray[i];
            switch (move) {
                case 1 -> side1++;
                case 2 -> side2++;
                case 3 -> side3++;
                case 4 -> side4++;
                case 5 -> side5++;
                case 6 -> side6++;
            }
        }
        System.out.println("Side1 = " + side1);
        System.out.println("Side2 = " + side2);
        System.out.println("Side3 = " + side3);
        System.out.println("Side4 = " + side4);
        System.out.println("Side5 = " + side5);
        System.out.println("Side6 = " + side6);
    }

    //================= methods ========================
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
