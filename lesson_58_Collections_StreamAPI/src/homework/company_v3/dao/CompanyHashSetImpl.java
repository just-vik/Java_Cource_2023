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
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double totalSalary() {
        return employees.stream()
                .mapToDouble(Employee::calcSalary)
                .sum();
    }

    @Override
    public double avgSalary() {
        return totalSalary() / employees.size();
    }

    @Override
    public double totalSales() {
        return employees.stream()
                .filter(e -> e instanceof SalesManager)
                .mapToDouble(e -> ((SalesManager) e).getSalesValue())
                .sum();
    }

    @Override
    public void printEmployees() {
        employees.forEach(System.out::println); //отправляем все элементы на печать
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
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }
}
