package practice;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeDataAppl {
    public static void main(String[] args) throws FileNotFoundException {
        //ссчитать данные из файла employees.csv
        try (BufferedReader br = new BufferedReader(new FileReader("src/practice/employees.csv"))) {
            String str = br.readLine(); //ссчитали 1 строку
            String[] cells = str.split(",");
            printCells(cells);
            // total salary
            // total employees
            // average salary
            // average age
            //читаем по строкам и что можем считаем сразу
            double salary = 0;
            int counter = 0;
            int age = 0;
            str = br.readLine();
            while (str  != null) {// читаем строки, пока не достигнем null
                counter++;
                cells = str.split(",");
                salary += Double.parseDouble(cells[2]); //cells[2] - так как индек колонки с зп находится на 2 индексе
                LocalDate birthDate = LocalDate.parse(cells[3]); //ссчитали как текст
                age += ChronoUnit.YEARS.between(birthDate, LocalDate.now());
                printCells(cells);
                str=br.readLine();
            }
            System.out.println("Total Salary: " + salary);
            System.out.println("Total Employees: " + counter);
            System.out.println("Average Salary: " + salary/counter);
            System.out.println("Average Age: " + age/counter);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printCells(String[] cells) {
        for (String s : cells) {
            System.out.print(s + "\t"); // "\t" - это табуляция(отступление на 1 TAB)
        }
        System.out.println();
    }


}
