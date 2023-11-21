package practice.seasons;

public class SeasonAppl {
    public static void main(String[] args) {
        // Опробовать на нем методы:
        // .values()
        // .toString
        // .ordinal()
        // .valueOf()

        Season[] seasons = Season.values();//пробегает по всем объектам(константам) и заносит значения enum в массив
        System.out.println(seasons.length);

        System.out.println("------------values 1--------------");
        //for loop
        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i].getName());
        }

        System.out.println("------------values 2--------------");
        //for each
        for (Season s : seasons) {
            System.out.println(s.getNumber());
        }

        System.out.println("------------toString()--------------");
        String str = Season.WIN.toString(); // String str = Season.WIN.getName().toString();
        System.out.println(str);

        System.out.println("------------ordinal()--------------");
        int n = Season.AUT.ordinal();
        System.out.println(n);

//Для обратного преобразования (строки в объект `Day`)
//можно воспользоваться статическим методом `valueOf()`
//Day day = Day.valueOf("MONDAY"); // day = Day.MONDAY
        System.out.println("------------valueOf()--------------");
        Season s = Season.valueOf("SUM");
        System.out.println(s.getName() + " - is the best time of the year!");
    }
}
