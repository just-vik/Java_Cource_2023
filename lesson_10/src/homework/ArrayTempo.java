package homework;

//Собрать в массив данные о дневной температуре в вашем городе да прошедшую неделю. Выведите на печать температуру, которая была во вторник и затем в четверг.
//Найти среднюю температуру за прошлую неделю.
public class ArrayTempo {
    public static void main(String[] args) {
        double[] arrayTempo = {27.0, 27.0, 21.0, 20.0, 22.0, 24.0, 26.0};
        double avrg = 0;
        System.out.println("The temperature in Hofheim last Tuesday: \n" + arrayTempo[1] + " °C");
        System.out.println("The temperature in Hofheim last Thursday: \n" + arrayTempo[3] + " °C");

        for (int i = 0; i < arrayTempo.length; i++) {
        }
        for (int i = 0; i < arrayTempo.length; i++) {
            avrg += arrayTempo[i] / 7;
        }
        System.out.printf("The average daily temperature in Hofheim for 37 week: \n%.2f", avrg);
        System.out.println(" °C");
    }
}
