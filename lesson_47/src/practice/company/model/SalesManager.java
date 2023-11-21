package practice.company.model;

public class SalesManager extends Employee {
    private double salesValue;
    private double percent;

    public SalesManager(int id, String firstName, String lastName, int age, double hours, double workExperience, String education, double salesValue, double percent) {
        super(id, firstName, lastName, age, hours, workExperience, education);
        this.salesValue = salesValue;
        this.percent = percent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public double calcSalary() {
        double salary = salesValue * percent;
        return salary;
    }

}
