package practice.company.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.company.dao.Company;
import practice.company.dao.CompanyImplement;
import practice.company.model.Employee;
import practice.company.model.Manager;
import practice.company.model.SalesManager;
import practice.company.model.Worker;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplementTest {

    Company company;
    Employee[] employee;


    @BeforeEach
    void setUp() {
        company = new CompanyImplement(5);
        employee = new Employee[4];

        employee[0] = new Manager(101, "John", "Smith", 45, 160, 5000, 5);
        employee[1] = new SalesManager(102, "Anna", "Black", 36, 160, 25000, 0.1);
        employee[2] = new SalesManager(103, "Thomas", "White", 28, 160, 30000, 0.1);
        employee[3] = new Worker(104, "Gans", "Bauer", 30, 160, 5);

    }

    @Test
    void addEmployee() {
        // не можем добавить null
        assertFalse(company.addEmployee(null));
        // не можем добавить 2ой раз уже существующий
        assertFalse(company.addEmployee(employee[1]));
        // создаем и добавляем нового сотрудника
        Employee employee1 =new Manager(105,"Ivan","Dubin",55,160,6000,6);
        assertTrue(company.addEmployee(employee1));
        // проверяем кол-во сотрудников после добавления
        assertEquals(5,company.quantity());
        // проверяем что не можем превысить capacity
        Employee employee2 =new Manager(106,"Peter","Dubin",54,160,6000,6);
        assertFalse(company.addEmployee(employee2));
    }

    @Test
    void removeEmployee() {
        // удаляем сотрудника
        assertEquals(employee[1],company.removeEmployee(102));
        // проверяем кол-во сотрудников после удаления
        assertEquals(3,company.quantity());
        // проверяем, можем ли удалить дважды
        assertNull(company.removeEmployee(102));
        // проверяем повторным поиском, что не возможно найти после удаления - вернется null
        assertNull(company.findEmployee(102));
    }

    @Test
    void findEmployee() {
        // ищем сотрудника по id
        assertEquals(employee[2], company.findEmployee(103));
        // ищем несуществующего сотрудника
        assertNull(company.findEmployee(105));
    }

    @Test
    void quantity() {
    }

    @Test
    void totalSalary() {
    }

    @Test
    void avgSalary() {
    }

    @Test
    void totalSales() {
    }

    @Test
    void printEmployees() {
    }
}