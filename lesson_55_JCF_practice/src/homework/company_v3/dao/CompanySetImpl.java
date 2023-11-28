package homework.company_v3.dao;

import homework.company_v3.model.Employee;
import homework.company_v3.model.SalesManager;

import java.util.Comparator;
import java.util.TreeSet;

public class CompanySetImpl implements Company{
    private TreeSet<Employee> employees;

    public CompanySetImpl(int i) {
        this.employees = new TreeSet<>(Comparator.comparingInt(Employee::getId));
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        return employees.add(employee);
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee toRemove = findEmployee(id);
        if (toRemove != null) {
            employees.remove(toRemove);
            return toRemove;
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double totalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calcSalary();
        }
        return totalSalary;
    }

    @Override
    public double avgSalary() {
        if (employees.isEmpty()) {
            return 0;
        }
        return totalSalary() / employees.size();
    }

    @Override
    public double totalSales() {
        double totalSales = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager) {
                totalSales += employee.calcSalary();
            }
        }
        return totalSales;
    }

    @Override
    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getHours() > hours) {
                count++;
            }
        }
        Employee[] result = new Employee[count];
        int index = 0;
        for (Employee employee : employees) {
            if (employee.getHours() > hours) {
                result[index++] = employee;
            }
        }
        return result;
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.calcSalary() >= minSalary && employee.calcSalary() <= maxSalary) {
                count++;
            }
        }
        Employee[] result = new Employee[count];
        int index = 0;
        for (Employee employee : employees) {
            if (employee.calcSalary() >= minSalary && employee.calcSalary() <= maxSalary) {
                result[index++] = employee;
            }
        }
        return result;
    }
}
