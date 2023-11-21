package homework;

//Напишите метод, принимающий массив целых чисел, и печатающий его в обратном порядке.
//Сначала последний элемент, потом предпоследний, и т.д.
//Измените (лучше скопируйте и сделайте еще один метод) метод так,
//чтобы он работал с массивом, заполненном "цифрами прописью": zero, one, two, three, ..., nine
//Выполните "разворот" это массива.
public class RevArray {
    public static void main(String[] args) {

        int[] numsArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] wordsArray = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        revNum(numsArray);
        revWords(wordsArray);
    }

    //метод для массива строк
    public static void revWords(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //метод для массива целых чисел
    public static void revNum(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) { //начинается с последнего элемента и заполняется к первому элементу 0
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
