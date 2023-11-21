package homework.student.model;

public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private int yearBirthday;
    private String specialization;

    public Students(int id, String firstName, String lastName, int yearBirthday, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBirthday = yearBirthday;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getYearBirthday() {
        return yearBirthday;
    }
    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void displayInfo(){
        System.out.println("Id: " + id + "\nFirst name: " + firstName + "\nLast name: "
                + lastName + "\nYear Birthday: " + yearBirthday + "\nSpecialization: " + specialization);
    }
    public void study(){
        System.out.println(firstName+ " studying");
    }
    public void vacation(){
        System.out.println(firstName+ " took a vacation");
    }
    public void exam(){
        System.out.println(firstName+ " takes an exam");
    }
    public void course(){
        System.out.println(firstName+ " attends a course");
    }
    public void skip(){
        System.out.println(firstName+ " skips classes.");
    }
}
