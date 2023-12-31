package homework.company_v3.dao;

import homework.company_v3.model.Employee;
import homework.company_v3.model.SalesManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CompanyHashSetImpl implements Company {

    private Set<Employee> employees; // вместо List создаем Set
    int capacity; // вместимость компании

    //конструктор
    public CompanyHashSetImpl(int capacity) {
        this.capacity = capacity; // это ограничение по кол-ву сотрудников в компании
        employees = new HashSet<>(); // длину (размер) указывать не надо
    }

    // O(1) константная вычислительная сложность,в худшем случае O(n)
    @Override
    public boolean addEmployee(Employee employee) {
        // не добавляем null, не превышаем capacity, не добавляем уже существующий элемент.
        if (employee == null || employees.size() == capacity) {
            return false;
        }
        return employees.add(employee);// добавили в список сотрудника (элемент множества — оно же Set)
        // операция добавления и удаления из множества(Set) имеет вычислительную сложность O(1)
    }

    // O(1) константная вычислительная сложность,в худшем случае O(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
        //множества не содержат в общем случае элемент null, поэтому проверка на наличие null не нужна.
    }

    // O(n) линейная вычислительная сложность
    @Override
    public Employee findEmployee(int id) {
        for (Employee e : employees) { // e - это employee из списка employees
            if (e.getId() == id) {
                return e; // вернули найденный элемент
            }
        }
        return null;
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double totalSalary() {
        double res = 0;
        for (Employee e : employees) {
            res += e.calcSalary();
        }
        return res;
    }

    @Override
    public double avgSalary() {
        return totalSalary() / employees.size();
    }

    @Override
    public double totalSales() {
        double res = 0;
        for (Employee e : employees) {
            if (e instanceof SalesManager) {
                //SalesManager salesManager = (SalesManager) e;
                res += ((SalesManager) e).getSalesValue(); //проводим кастинг до нужного типа
            }
        }
        return res;
    }

    @Override
    public void printEmployees() {
        employees.forEach(e -> System.out.println(e)); //отправляем все элементы на печать
    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return findEmployeeByPredicate(e -> e.getHours() >= hours);
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeeByPredicate(e -> e.calcSalary() >= minSalary && e.calcSalary() <= maxSalary);
    }

    private Employee[] findEmployeeByPredicate(Predicate<Employee> predicate) {
        List<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                res.add(employee);
            }
        }
        return res.toArray(new Employee[0]); //новинка
    }
}
