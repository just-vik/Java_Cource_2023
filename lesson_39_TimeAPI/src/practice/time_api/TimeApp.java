package practice.time_api;

//        **Работа с датами:**
//        - узнать текущую дату и время
//        - есть дата, какой это был день недели? день месяца? день года?
//        - есть дата, как узнать, это было раньше? или позже?

//          **Путешествие во времени**
//        - в будущее currentDay.plus
//        - в прошлое currentDay.minus
//        - использование ChronoUnit

//          **Получение интервала времени**
//          **Сортировка массива по времени**
//          **Date Formatter**
//          **Парсинг даты из строки**

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class TimeApp {
    public static void main(String[] args) {
        LocalDate currentDay = LocalDate.now(); //международный формат даты
        System.out.println(currentDay);

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentDay + " " + currentTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("=========================================");
        LocalDate birthday = LocalDate.of(1986, 10, 22); //задаем дату
        System.out.println(birthday.getYear());
        System.out.println(birthday.getDayOfWeek());
        System.out.println("=========================================");
        LocalDate gagarin = LocalDate.of(1961, 4, 12); //задаем дату
        System.out.println(gagarin.getYear());
        System.out.println(gagarin.getDayOfYear());
        System.out.println("Start Gagarin day of week: " + gagarin.getDayOfWeek());

        System.out.println(gagarin.isBefore(currentDay)); // ожидаем true
        System.out.println(gagarin.isAfter(currentDay)); // ожидаем false

        System.out.println("===============Traveling in time==============");
        LocalDate newDate = currentDay.plusDays(50);
        System.out.println(newDate);
        newDate = currentDay.plusWeeks(12);
        System.out.println(newDate);
        // 2 month ago
        newDate = currentDay.minusMonths(2);
        System.out.println("Two month ago: " + newDate);

        //operations with chronoUnits
        System.out.println(localDateTime.plus(9, ChronoUnit.HALF_DAYS)); //сколько половинок дней прошло по 12 часов
        // CENTURIES - 100 years
        newDate = currentDay.plus(2, ChronoUnit.CENTURIES);
        System.out.println("In 2 centuries: " + newDate);
        System.out.println("It will be day of week: " + newDate.getDayOfWeek());

        //getting a time interval (how many years have passed? how old is the person?)
        LocalDate einstein = LocalDate.of(1879, 3, 14);
        long res = ChronoUnit.YEARS.between(einstein, gagarin);
        System.out.println(res);

        System.out.println("Compare dates");
        System.out.println(einstein.compareTo(gagarin)); //сравнение дат
        LocalDate yesterday = LocalDate.of(2023, 10, 30);
        System.out.println(currentDay.compareTo(yesterday));

        //sorting time
        LocalDate[] dates = {yesterday, einstein, gagarin, currentDay};
        System.out.println(Arrays.toString(dates)); //неотсортированные даты
        Arrays.sort(dates); // сортируем массив
        System.out.println(Arrays.toString(dates));


        System.out.println("===== DateTimeFormatter =====");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
        String date = gagarin.format(df);
        System.out.println(date);
        date = gagarin.toString();
        System.out.println(date);
        df = DateTimeFormatter.ISO_LOCAL_DATE;
        date = localDateTime.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/M/yyyy");
        date = gagarin.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.FRANCE);
        date = gagarin.format(df);
        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("uk"));
        date = gagarin.format(df);
        System.out.println(date);
        date = "31/10/2023";
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newDate = LocalDate.parse(date, df);
        System.out.println(newDate.toString());
        System.out.println(newDate.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));

    }

}
