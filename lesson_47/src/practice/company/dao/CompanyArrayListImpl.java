package practice.company.dao;

import practice.company.model.Employee;
import practice.company.model.SalesManager;

import java.util.ArrayList;
import java.util.List;


public class CompanyArrayListImpl implements Company {
//    // поля
//    private Employee[] employees; // массив для хранения всех сотрудников
//    private int size; // текущее количество сотрудников

    List<Employee> employees; //вместо массива делаем List
    int capacity; //вместимость компании

    //    // конструктор
//    public CompanyImpl(int capacity) {
//        employees = new Employee[capacity]; // capacity - максимальное значение размера компании
//    }
    public CompanyArrayListImpl(int capacity) {
        employees = new ArrayList<>(); //длину(размер) указывать не надо
        this.capacity = capacity; // это ограничение по кол-ву сотрудников в компании
    }


    @Override
    public boolean addEmployee(Employee employee) {
//        не добавляем null, не превышаем capacity, не добавляем уже существующего
//        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
//            return false;
//        }
//        employees[size] = employee; //новый элемент
//        size++;
//        return true;
        if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees.add(employee); //добавили в список сотрудника (элемент списка)
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getId() == id) {
//                Employee victim = employees[i]; //убрали найденный элемент в переменную
//                employees[i] = employees[--size]; //на место найденного поставили последний существующего в массиве
//                employees[size] = null; //обнулили последнего
//                return victim;
//            }
//        }
//        return null;

        Employee victim = findEmployee(id);
        if (victim != null) { //а надо ли это проверять?
            employees.remove(victim);
            return victim;
        }
        return null;
    }

    // O(n)
    @Override
    public Employee findEmployee(int id) {
//        for (int i = 0; i < size; i++) { //пробегает только по заполненным элементам массива которые отражаются в size
//            if (employees[i].getId() == id) { // нашелся элемент массива у которого совпал id
//                return employees[i]; //вернули найденного работника(элемент массива типа Employee)
//            }
//        }
//        return null;
        for (Employee e : employees) { // e - это employee из списка employees
            if (e.getId() == id) {
                return e; //вернули найденный элемент
            }
        }
        return null;
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size(); //вернули длину списка
    }

    // O(n) сложность линейная потому что перебираем
    @Override
    public double totalSalary() {
//        double res = 0;
//        for (int i = 0; i < size; i++) {
//                res += employees[i].calcSalary();
//
//            }
//        }
        double res = 0;
        for (Employee e : employees) {
            res += e.calcSalary();
        }
        return res;
    }

    // O(1) сложность константная
    @Override
    public double avgSalary() {
        return totalSalary() / employees.size();
    }

    // O(n) сложность линейная
    @Override
    public double totalSales() {
//        double res = 0;
//        for (int i = 0; i < size; i++) {
//            if (employees[i] instanceof SalesManager) {
//                SalesManager salesManager = (SalesManager) employees[i]; //down-casting
//                res += salesManager.getSalesValue();
//            }
//        }
//        return res;
        double res = 0;
        for (Employee e : employees) {
            if (e instanceof SalesManager) {
                res += ((SalesManager) e).getSalesValue();
            }
        }
        return res;
    }

    // O(n) сложность линейная
    @Override
    public void printEmployees() {
        for (Employee e:employees) {
            System.out.println(e);
        }

    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
//        int count = 0;
//        // считаем сколько будет элементов массива, удовлетворяющих условию
//        for (int i = 0; i < size; i++) {
//            if(employees[i].getHours() > hours){
//                count++;
//            }
//        }
//        Employee[] res = new Employee[count]; // создаем массив размером count
//        // заполняем массив res
//        for (int i = 0, j = 0; j < res.length; i++) {
//            if(employees[i].getHours() > hours){
//                res[j++] = employees[i];
//            }
//        }
//        return res; // это возвращаемый массив

        int count =0;
        for (Employee e:employees) {
            if (e.getHours()>hours) {
                count++;
            }
        }
        Employee[] res = new Employee[count];
        count=0;
        for (Employee e:employees){
            if (e.getHours()>hours) {
                res[count]=employees.get(count);
                count++;
            }
        }
        return res;
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) { //O(n)

        int count = 0;  //O(1)
        // считаем кол-во сотрудников в диапазоне зарплат
        for (Employee e : employees) { //O(n)
            if (e.calcSalary() >= minSalary && e.calcSalary() <= maxSalary) {
                count++;
            }
        }
        // Создаем массив для хранения сотрудников в пределах диапазона зарплат
        Employee[] res = new Employee[count];  //O(1)
        // Заполняем массив сотрудниками в пределах диапазона зарплат
        count = 0;
        for (Employee e : employees) {
            if (e.calcSalary() >= minSalary && e.calcSalary() <= maxSalary) {
                res[count] = e;
                count++;
            }
        }

        return res;
    }
}
