package homework.alphabet_arraylist;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    public static void main(String[] args) {
        List<String> alphabetList1 = new ArrayList<>();
        List<String> alphabetList2 = new ArrayList<>();
        //Вариант 1
        // заполняем массив символами латинского алфавита от A(65) до Z(...).
        for (int i = 65; i <= 90; i++) {
            // добавляем символы (использую char) преобразуя в строку
            alphabetList1.add(String.valueOf((char)i));
        }

        //Вариант 2
        for (int i = 'A'; i <= 'Z'; i++) {
            alphabetList2.add(String.valueOf((char)i));
        }
        // печать
        System.out.println("➊ Alphabet 65-90 " + alphabetList1);
        System.out.println("➋ Alphabet A-Z " + alphabetList2);
    }
}
