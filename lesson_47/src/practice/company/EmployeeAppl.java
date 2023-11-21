package practice.company;

import practice.company.model.Employee;
import practice.company.model.Manager;
import practice.company.model.SalesManager;
import practice.company.model.Worker;

import java.util.*;

public class EmployeeAppl {
    public static void main(String[] args) {

        Employee[] empl = new Employee[4];
        empl[0] = new Manager(100, "John", "Smith", 45, 160, 7.5, "ECONOMY",5000,5);
        empl[1] = new SalesManager(101,"Anna", "Black", 36, 160, 8.6, "MARKETING",25000,0.1);
        empl[2] = new SalesManager(102,"Thomas", "White", 28, 160, 4.2, "ACCOUNTING",30000,0.1);
        empl[3] = new Worker(103, "Gans", "Bauer", 30, 80, 3.5,"LAWYER",5);

        double total = totalSalary(empl); // вызываем метод для расчета зарплаты
        System.out.println("Total salary: " + total);
        double average = averageAge(empl);
        System.out.println("Average age: " + average);
        double totalSales = totalSales(empl);
        System.out.println(totalSales);

        //оборачиваем существующий массив (Array.asList(обертываемый массив))
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(empl));
        System.out.println("--------------sort by experience------------------");
        Collections.sort(employeeList, Comparator.comparing(Employee::getWorkExperience));
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println("--------------sort by  education------------------");
        Collections.sort(employeeList, Comparator.comparing(Employee::getEducation));
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }


    }

    private static double totalSalary(Employee[] empl){
        double sum = 0;
        for (int i = 0; i < empl.length; i++) {
            if(empl[i] != null){
                sum += empl[i].calcSalary();
            }
        }
        return sum;
    }

    private static double averageAge(Employee[] empl) {
        double average = 0;
        for (int i = 0; i < empl.length; i++) {
            if(empl[i] != null){
                average += empl[i].getAge();
            }
        }
        return average / empl.length;
    }

    private static double totalSales(Employee[] empl){
        double sum = 0;
        for (int i = 0; i < empl.length; i++) {
            if(empl[i] instanceof SalesManager){
                SalesManager salesManager = (SalesManager) empl[i];
                sum += salesManager.getSalesValue();
            }
        }
        return sum;
    }
}
