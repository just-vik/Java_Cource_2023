package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static practice.EmployeeDataAppl.printCells;

public class TitanicPassengersAppl {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/homework/train.csv"))) {
            String str = br.readLine(); //ссчитали 1 строку
            String[] cells = str.split(",");
            printCells(cells);
            // - total fare
            // общая стоимость проезда
            // - average fare for 1, 2, 3 travel classes
            // средний тариф для 1,2,3 классов путешествия
            // - total number of surviving and dead passengers
            // общее количество выживших и погибших пассажиров
            // - total number of surviving and dead men, women and children (under 18 years of age)
            // общее количество выживших и погибших мужчин, женщин и детей (до 18 лет).
            double totalFare = 0; //переменная для общей стоимости проезда
            int totalPassengers = 0; //переменная для общего количества пассажиров
            int totalSurvivors = 0; //переменная для общего количества выживших
            int totalMen = 0; //переменная для общего количества мужчин
            int totalWomen = 0; //переменная для общего количества женщин
            int totalChildren = 0; //переменная для общего количества детей

            str = br.readLine();//следующая строка поле загаловка(13 line)
            while (str != null) {
                totalPassengers++;
                cells = str.split(",");
                //total fare
                //TODO ошибка подсчета по 9 индексу
                double fare = Double.parseDouble(cells[9]);//в 3 индексе аргумент из за лишней запятой разделяется и кол-во арнументов в строку не соответствуют заголовкам
                totalFare += fare;

                //total qty of surviving and dead passengers
                int survival = Integer.parseInt(cells[1]);
                if (survival == 1) {
                    totalSurvivors++;
                }

                //total qty of surviving and dead men, women and children (under 18 years of age)
                String sex = cells[4];
                double age = Double.parseDouble(cells[5]);// 5 index - age
                if (sex.equalsIgnoreCase("male")) {
                    totalMen++;
                } else {
                    totalWomen++;
                }
                if (age < 18) {
                    totalChildren++;
                }

                str = br.readLine(); //следующая строки
            }

            System.out.println("Общая стоимость проезда: " + totalFare);
            System.out.println("Общее количество пассажиров: " + totalPassengers);
            System.out.println("Общее количество выживших: " + totalSurvivors);
            System.out.println("Общее количество мужчин: " + totalMen);
            System.out.println("Общее количество женщин: " + totalWomen);
            System.out.println("Общее количество детей: " + totalChildren);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
