package practice.month;

public enum Month {
    // set constants
    JAN("January", 31), FEB("February", 28),
    MAR("March", 31), APR("April", 30),
    MAY("May", 31), JUN("June", 30),
    JUL("July", 31), AUG("August", 31),
    SEP("September", 30), OCT("October", 31),
    NOV("November", 30), DEC("December", 31);

    //class fields
    private String name;
    int days;

    // constructor
    Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

//Задайте enum Month, определите месяца, их наименования и количество в них дней.
//Реализуйте метод, позволяющий прибавлять месяца к выбранному, получая правильный месяц.
//Пример: AUG + 6 month = FEB Проверьте работу метода в приложении.

    //method to increase the qty of months
    public Month plusMonth(int qty) {
        int index = ordinal(); //current month number
        index = index + qty; //increased the qty of months
        Month[] months = values(); // enter all constants into an array of type month
        return months[index % months.length]; // return an object of type month whose index = % 12


    }
}
