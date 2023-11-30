package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitsFreqApp {
    public static void main(String[] args) {
        int totalNums = 10;//общее кол-во чисел для генерации(можно поставить и 1_000_000)
        Map<Integer, Integer> digitFreq = new HashMap<>();//HashMap для подсчета повторений

        //генерируем положительные числа в пределах от 1 до totalNums
        for (int i = 1; i < totalNums; i++) {
            Random random = new Random();
            int number = random.nextInt(Integer.MAX_VALUE);
            System.out.println(number);
            countDigitFrequency(digitFreq,number);//подсчет кол-ва повторяющихся цифр
        }
        digitFreq.forEach((digit, freq) -> System.out.println(digit + " => " + freq));
    }
    //подсчет кол-ва повторяющихся цифр
    private static void countDigitFrequency (Map < Integer, Integer > digitFreq,int number){
        String digits = String.valueOf(number); //переводим число в строку
        //подсчет кол-во повторяющихся цифр в числе
        for (char digitChar : digits.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            digitFreq.put(digit, digitFreq.getOrDefault(digit, 0) + 1); //счетчик
        }
    }
}
