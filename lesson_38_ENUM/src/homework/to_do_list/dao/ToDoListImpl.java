package homework.to_do_list.dao;

//5. ToDoListImpl - создать, реализовать методы.


import homework.to_do_list.model.Task;

public class ToDoListImpl implements ToDoList {
    private Task[] tasks = new Task[10];
    private int size = 0;


    @Override
    public void addTask(Task task) {
        if (size < tasks.length) {
            tasks[size] = task;
            size++;
        }
    }

    @Override
    public void viewTasks() {
        if (size == 0) {
            System.out.println("The task list is empty.");
        } else {
            System.out.println("Task list:");
            for (int i = 0; i < size; i++) {
                System.out.println(tasks[i]);
            }
        }
    }


    @Override
    public void deleteTask(int taskNumber) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].getTaskNumber() == taskNumber) {
                for (int j = i; j < size - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                size--;
                System.out.println("Task deleted.");
                return;
            }
        }
        System.out.println("The task with this number was not found.");
    }

    public int qty() {
        return size;
    }
}
