package homework;

//Распечатайте все числа меньшие 200 и кратные 13.
public class Digits {
    public static void main(String[] args) {
        int count = 1;
        while (count <= 200) {
            if (count % 13 == 0) {
                System.out.print(count + " | ");
            }
            count++;
        }
    }
}
