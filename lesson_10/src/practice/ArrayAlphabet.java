package practice;

// Создайте массив и заполните его символами латинского алфавита от A до Z.
// Раcпечатайте полученный массив.
public class ArrayAlphabet {
    public static void main(String[] args) {
        //заполнить массив числами от 1 до 20
        int[] arrayNum = new int[20]; //объявили длину массива в 20

        // цикл заполнения массива данными
        for (int i = 0; i < arrayNum.length; i++) { //метод length дает его длинну. i пробегает значение от 0 до
            arrayNum[i] = i + 1; //заполняем элементы массива(в 0 элемент попадет 1)

        } //цикл для печати массива
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.print(arrayNum[i] + ", ");
        }
        System.out.println(); //переход на новую строку

        //System.out.println(arrayNum[0]);//нулевой по индексу элемент
        //System.out.println(arrayNum[19]);
        //System.out.println(arrayNum[20]); //выход за пределы массива

        char[] alphabet = new char[26];
        //заполнение
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (65 + i); //заполняем кодами код буквы A-65 B-66...
        }

        //печать массива
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");

        }
    }
}
