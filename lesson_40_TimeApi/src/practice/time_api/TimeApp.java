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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
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


        System.out.println("===== Date Time Formatter =====");
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE; //определили формат даты по константе
        System.out.println(gagarin.format(df));
//        String date = gagarin.format(df);
//        System.out.println(date);
        df = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH); //задали другой формат отображения
        System.out.println(gagarin.format(df));

        System.out.println("--------------- parsing data from string ----------------");
        String str = "01/11/2023";
        System.out.println(str);

        System.out.println("----------------------");
        LocalDate date1 = dateParse(str); //делаем метод для конвертации строки в дату
        System.out.println(date1);

        System.out.println("----------------------");
        str = "2023-11-01";
        date1 = dateParse(str);
        System.out.println(date1.getDayOfWeek());


    }

    private static LocalDate dateParse(String data) { //строка на входе
        DateTimeFormatter df = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd/MM/yyyy][dd.MM.yyyy][dd-MM-yyyy][dd:MM:yyyy][dd MM yyyy]"); //определяем как преобразовать строку в дату
        return LocalDate.parse(data, df); //преобразование в дату
    }
}
