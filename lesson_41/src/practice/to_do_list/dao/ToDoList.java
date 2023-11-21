package practice.to_do_list.dao;

//4. Интерфейс ToDoList должен соответствовать функциям меню.

import practice.to_do_list.model.Task;

public interface ToDoList {
    void addTask(Task task);

    void viewTasks();

    void deleteTask(int taskNumber);

    int qty();
}
