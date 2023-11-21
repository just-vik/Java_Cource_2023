package practice.company.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.company.dao.Company;
import practice.company.dao.CompanyImplement;
import practice.company.model.Employee;
import practice.company.model.Manager;
import practice.company.model.SalesManager;
import practice.company.model.Worker;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplementTest {

    Company company;
    Employee[] e;


    @BeforeEach
    void setUp() {
        company = new CompanyImplement(5);
        e = new Employee[4];

        e[0] = new Manager(101, "John", "Smith", 45, 160, 5000, 5);
        e[1] = new SalesManager(102, "Anna", "Black", 36, 160, 25000, 0.1);
        e[2] = new SalesManager(103, "Thomas", "White", 28, 160, 30000, 0.1);
        e[3] = new Worker(104, "Gans", "Bauer", 30, 80, 5);

        //добавим элементы массива в company
        for (int i = 0; i < e.length; i++) {
            company.addEmployee(e[i]);

        }
    }

    @Test
    void addEmployee() {
        // не можем добавить null
        assertFalse(company.addEmployee(null));
        // не можем добавить 2ой раз уже существующий
        assertFalse(company.addEmployee(e[1]));
        // создаем и добавляем нового сотрудника
        Employee employee1 = new Manager(105, "Ivan", "Dubin", 55, 160, 6000, 6);
        assertTrue(company.addEmployee(employee1));
        // проверяем кол-во сотрудников после добавления
        assertEquals(5, company.quantity());
        // проверяем что не можем превысить capacity
        Employee employee2 = new Manager(106, "Peter", "Dubin", 54, 160, 6000, 6);
        assertFalse(company.addEmployee(employee2));
    }

    @Test
    void removeEmployee() {
        // удаляем сотрудника
        assertEquals(e[1], company.removeEmployee(102));
        // проверяем кол-во сотрудников после удаления
        assertEquals(3, company.quantity());
        // проверяем, можем ли удалить дважды
        assertNull(company.removeEmployee(102));
        // проверяем повторным поиском, что не возможно найти после удаления - вернется null
        assertNull(company.findEmployee(102));
        company.printEmployees();
    }

    @Test
    void findEmployee() {
        // ищем сотрудника по id
        assertEquals(e[2], company.findEmployee(103));
        // ищем несуществующего сотрудника
        assertNull(company.findEmployee(105));
    }

    @Test
    void quantityTest() {
        assertEquals(4, company.quantity());
    }

    @Test
    void totalSalaryTest() {
        assertEquals(12100, company.totalSalary(), 0.01);
    }

    @Test
    void avgSalary() {
        assertEquals(12100.0 / 4, company.avgSalary(), 0.01);
    }

    @Test
    void totalSales() {
        assertEquals(55000, company.totalSales(), 0.01);
    }

    @Test
    void printEmployees() {
        company.printEmployees();
    }

    @Test
    void findEmployeesHoursGreaterThanTest() {
        Employee[] actual = company.findEmployeesHoursGreaterThan(100);
        Employee[] expected = {e[0], e[1], e[2]}; //заполняем элементы массива с часами >100
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesSalaryRangeTest() {
       // company.printEmployees();
        Employee[] actual = company.findEmployeesSalaryRange(2900, 6000);
        Employee[] expected = {e[0], e[2]};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
}