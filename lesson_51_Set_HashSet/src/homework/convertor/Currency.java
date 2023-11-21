package homework.convertor;

public enum Currency {
    USD(1, "USD", 1.12),
    CHF(2, "CHF", 1.03),
    GBP(3, "GBP", 1.17),
    JPY(4, "JPY", 0.009),
    EUR(5, "EUR", 1);

    private int number;
    private String name;
    private double course;

    Currency(int number, String name, double course ) {
        this.number = number;
        this.name = name;
        this.course = course;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "===> " + number +
                " " + name +
                " course = " + course;
    }
}
