package practice.to_do_list;

import practice.to_do_list.dao.ToDoList;
import practice.to_do_list.dao.ToDoListImpl;
import practice.to_do_list.model.Menu;
import practice.to_do_list.model.Task;

import java.util.Scanner;

//6. ToDoAppl - приветствие пользователю, печать меню,
//запрос выбора пользователя(бесконечный цикл + switch case).

public class ToDoAppl {
    public static void main(String[] args) {
        System.out.println("Welcome to ToDo List app!");
        ToDoList toDoList = new ToDoListImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.printMenu();
            int choice = scanner.nextInt();  // выбираем номер в меню
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Input your task: ");
                    String taskDescription = scanner.nextLine();
                    System.out.print("Input task number: ");
                    int taskNumber = scanner.nextInt();
                    // создаем новую задачу с введенным номером
                    Task newTask = new Task(toDoList.qty() + 1, taskDescription, taskNumber);
                    // добавляем задачу в список
                    toDoList.addTask(newTask);
                    System.out.println("Task added.");
                    break;
                case 2:
                    toDoList.viewTasks(); //список задач
                    break;
                case 3:
                    System.out.print("Input task number for delete: ");
                    int taskNumToDel = scanner.nextInt();
                    // удаляем задачу с указанным номером
                    toDoList.deleteTask(taskNumToDel);
                    break;
                case 4:
                    System.out.println("BYE!");
                    System.exit(0); //выход
                    break;
                default:
                    System.out.println("Wrong choice. Please try again.");
            }
        }
    }
}