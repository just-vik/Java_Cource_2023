package homework.todolist_file.dao;

import homework.todolist_file.model.Task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoListImpl implements ToDoList, Serializable {

    //fields
    private List<Task> tasks;
//    private int capacity;
//    private int quantity;
//    private LocalDateTime time; // TODO - добавить дату и время создания задачи

    // constructor
    public ToDoListImpl() {
        tasks = new ArrayList<>();
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    @Override
    public Task removeTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber < tasks.size()) {
            Task removed = tasks.remove(taskNumber);
            //так как в методе viewTasks мы tasks.indexOf(task)+1 (для корректного отображения номеров task),
            //что бы удалить под нужным индексом нужно taskNumber-1
            return removed;
        }
        System.out.println("Wrong task number.");
        return null;
    }


    @Override
    public void viewTasks() {
        int taskNumber = 1;
        for (Task task : tasks) {
            System.out.println("Task №: " + taskNumber  + task);
            taskNumber++;
        }
        if (tasks.size() > 1) {
            System.out.println("You have " + tasks.size() + " tasks.");
        } else {
            System.out.println("You have " + tasks.size() + " task.");
        }
    }

    @Override
    public int quantity() {
        return tasks.size();
    }
}
