package practice.month;

public class MonthAppl {
    public static void main(String[] args) {
        Month month = Month.FEB;
        System.out.println(month);
        System.out.println(month.plusMonth(2).getName()); //added 2 months
        System.out.println(month.plusMonth(13).getName()); //added 13 months
    }
}
