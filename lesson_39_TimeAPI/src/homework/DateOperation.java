package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

//В классе DateOperation (см. package homework) реализовать метод getAge,
// принимающий дату рождения в виде String, и возвращающий возраст в годах.
// *В классе DateOperation (см. package homework),
// реализовать метод sortStringDates, принимающий массив дат
// в виде массива данных типа String, и возвращающий отсортированный массив дат.
// Для проверки используйте класс DateOperationTest с Unit-тестами.


public class DateOperation {
    public static int getAge(String birthDate) {
        //birthDate = birthDate.replace("/", "-");

        LocalDate date = LocalDate.parse(birthDate); // парсим дату рождения
//        System.out.println(date);
        LocalDate currentDate = LocalDate.now(); // текущая дата
//        System.out.println(currentDate);
        long age = ChronoUnit.YEARS.between(date, currentDate); //вычисляем возраст
//        System.out.println(age);
        int res = (int) age;
        return res;
    }

    public static String[] sortStringDates(String[] dates) {
        LocalDate[] localDates = new LocalDate[dates.length];

//        for (int i = 0; i < dates.length; i++) {
//            localDates[i] = LocalDate.parse(dates[i]);
//        }


        return null;
    }
}
