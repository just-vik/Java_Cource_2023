package homework.todolist_file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import homework.todolist_file.dao.ToDoListImpl;
import homework.todolist_file.model.Menu;
import homework.todolist_file.model.Task;


public class ToDoListAppl {
    public static void main(String[] args) {
        // greeting
        System.out.println("Welcome to ToDo Application!");
        ToDoListImpl toDoList = new ToDoListImpl();

        // начало цикла
        while (true) {
            // print menu
            Menu.printMenu(); // статический метод вызывается по имени класса
            // ask choice
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your choice: ");
            int choice = scanner.nextInt();
            // execute
            switch (choice) {
                case 1: {
                    scanner.nextLine();
                    System.out.println("Input task: ");
                    String task = scanner.nextLine();
                    Task newTask = new Task(toDoList.quantity(), task);
                    toDoList.addTask(newTask);
                    break;
                }
                case 2: {
                    System.out.println("Your tasks: ");
                    toDoList.viewTasks();
                    break;
                }
                case 3: {
                    System.out.println("Input task number: ");
                    int taskNumber = scanner.nextInt();
                    Task removedTask = toDoList.removeTask(taskNumber-1);
                    if(!(removedTask == null)){
                        System.out.println(removedTask + " is removed.");
                    }
                    break;
                }
                case 4:{
                    System.out.println("Saving...");
                    for (int i = 0; i < 15; i++) {
                        try {
                            Thread.sleep(120); //задержка (текущий поток приостанавливается)
                            System.out.print("*"); //аля анимация
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/homework/todolist_file/task_folder/saved_tasks.txt"))) {
                        oos.writeObject(toDoList);
                        System.out.println("\nTask saved.");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 5:
                    return;
                default: {
                    System.out.println("Wrong input.");
                }
            }
        }
    }
}
