package practice.company.dao;

//Cоздаем интерфейс Company с методами:
// - добавить сотрудника
// - удалить сотрудника
// - найти сотрудника
// - кол-во сотрудников
// - ФОТ - з/п всех сотрудников
// - средняя з/п
// - объем продаж
// - напечатать список сотрудников


import practice.company.model.Employee;

public interface Company {
    //    объявляем методы, только сигнатуры, без тела метода
    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quantity();

    double totalSalary();

    double avgSalary();

    double totalSales();

    void printEmployees();

//    ---------------------------------------
//    - Список работников у которых отработано больше часов чем...
    Employee[] findEmployeesHoursGreaterThan(int hours);

//    - Список работников у которых з\п в интервале от... и до....
    Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary);



}
