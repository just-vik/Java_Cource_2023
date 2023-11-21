package practice.company.dao;

import practice.company.model.Employee;

public class CompanyImplement implements Company {

    // поля
    private Employee[] employees; // массив для хранения всех сотрудников
    private int size; // текущее количество сотрудников

    // конструктор
    public CompanyImplement(int capacity) {
        employees = new Employee[capacity]; // capacity - максимальное значение размера компании
    }


    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {

        }
        return null;
    }

    @Override
    public int quantity() {
        return 0;
    }

    @Override
    public double totalSalary() {
        return 0;
    }

    @Override
    public double avgSalary() {
        return 0;
    }

    @Override
    public double totalSales() {
        return 0;
    }

    @Override
    public void printEmployees() {

    }
}
