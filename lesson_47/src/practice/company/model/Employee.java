package practice.company.model;

import java.util.Objects;

public abstract class Employee {
    //fields
    protected final int id;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected double hours;
    protected double workExperience;
    protected String education;

    //constructor
    public Employee(int id, String firstName, String lastName, int age, double hours, double workExperience, String education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hours = hours;
        this.workExperience = workExperience;
        this.education = education;
    }

    //getters & setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    //equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(workExperience, employee.workExperience) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workExperience);
    }


    @Override
    public String toString() {
        return "Employee: " +
                "Id = " + id +
                ", First name: " + firstName + '\'' +
                ", Last name: " + lastName + '\'' +
                ", Age: " + age +
                ", Contract hours: " + hours +
                ", Work experience: " + workExperience +
                ", Education: " + education + '\'';
    }

    public abstract double calcSalary(); // определили абстрактный метод (у него нет тела!)

}
