package practice.employee;

import practice.employee.model.Employee;

public class FirmaAppl {
    public static void main(String[] args) {
        Employee empl1 = new Employee(2233, "Igor", "Spielberg", 39, 48000, true);
        Employee empl2 = new Employee(2234, "Mary", "Poppins", 35, 47300, false);
        empl1.display();
        System.out.println("________________________");
        empl2.display();
        System.out.println("========================");

        double totalSalary = empl1.getSalary() + empl2.getSalary();
        System.out.println("Total salary: " + totalSalary);

        empl1.work();
        empl1.lunch();
        empl1.lunch();
    }

}
