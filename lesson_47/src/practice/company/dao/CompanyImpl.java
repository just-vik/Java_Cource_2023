package practice.company.dao;

import practice.company.model.Employee;
import practice.company.model.SalesManager;

import java.util.Comparator;

public class CompanyImpl implements Company {
    // поля
    private Employee[] employees; // массив для хранения всех сотрудников
    private int size; // текущее количество сотрудников

    // конструктор
    public CompanyImpl(int capacity) {
        employees = new Employee[capacity]; // capacity - максимальное значение размера компании
    }


    @Override
    public boolean addEmployee(Employee employee) {
        // 3 условия: не добавляем null, не превышаем capacity, не добавляем уже существующего
        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[size] = employee; //новый элемент
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee victim = employees[i]; //убрали найденный элемент в переменную
                employees[i] = employees[size - 1]; //на место найденного поставили последний существующего в массиве
                employees[size - 1] = null; //обнулили последнего
                size--;
                // можно написать этот код короче TODO
                return victim;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) { //пробегает только по заполненным элементам массива которые отражаются в size
            if (employees[i].getId() == id) { // нашелся элемент массива у которого совпал id
                return employees[i]; //вернули найденного работника(элемент массива типа Employee)
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalSalary() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            res += employees[i].calcSalary();
        }
        return res;
    }

    @Override
    public double avgSalary() {
        if (size == 0) {
            return 0;
        }
        return totalSalary() / size;
    }

    @Override
    public double totalSales() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
                SalesManager salesManager = (SalesManager) employees[i]; //down-casting
                res += salesManager.getSalesValue();
                //  res += ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return res;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    //    Для выборки элементов из массива, удовлетворяющих заданному условию, надо:
//    - сначала подсчитать количество элементов массива, удовлетворяющих условию.
//    - потом создать массив под это количество,
//    - и только потом его заполнить.
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        int count = 0;
        // считаем сколько будет элементов массива, удовлетворяющих условию
        for (int i = 0; i < size; i++) {
            if(employees[i].getHours() > hours){
                count++;
            }
        }
        Employee[] res = new Employee[count]; // создаем массив размером count
        // заполняем массив res
        for (int i = 0, j = 0; j < res.length; i++) {
            if(employees[i].getHours() > hours){
                res[j++] = employees[i];
            }
        }
        return res; // это возвращаемый массив
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        // считаем сколько будет элементов массива, удовлетворяющих условию
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i].calcSalary() > minSalary && employees[i].calcSalary() < maxSalary) {
                count++;
            }
        }
        Employee[] res = new Employee[count]; // создаем массив размером count
        // заполняем массив res
        for (int i = 0, j = 0; j < res.length; i++) {
            if(employees[i].calcSalary() > minSalary && employees[i].calcSalary() < maxSalary){
                res[j++] = employees[i];
            }
        }
        return res; // это возвращаемый массив
    }

}
