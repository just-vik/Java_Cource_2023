package homework.sprint;

import practice.city_bus.Bus;

public class Athletes implements Comparable<Athletes> {
    //fields
    private int regNumber;
    private String firstName;
    private String lastName;
    private String club;
    private double result;


    //constructor
    public Athletes(int regNumber, String firstName, String lastName, String club, double result) {
        this.regNumber = regNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.club = club;
        this.result = result;
    }

    //getters & setters
    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
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

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    //to String
    @Override
    public String toString() {
        return "ATHLETE: " + " number: " + regNumber +
                "\n  First name: " + firstName +
                "\n  Last name: " + lastName +
                "\n  Club: " + club +
                "\n  With result: \u001B[1m" + result + "\u001B[0m sec."+
                "\n";

    }

    @Override
    public int compareTo(Athletes o) {
        int res = this.club.compareTo(o.club);
        return res != 0 ? res : -Integer.compare(this.regNumber, o.regNumber);
    }
}
