package homework.to_do_list.model;

//3. Реализовать класс Task (int id, String task, int taskNumber).
//Геттеры и сеттеры, toString, equals.
//Сделать класс Task сортируемым по номеру задачи.

import java.util.Objects;

public class Task implements Comparable<Task> {
    private int id;
    String task;
    int taskNumber;

    //конструктор
    public Task(int id, String task, int taskNumber) {
        this.id = id;
        this.task = task;
        this.taskNumber = taskNumber;
    }


    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Task { ");
        sb.append(", taskNumber = ").append(taskNumber);
        sb.append(", task = '").append(task).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Task otherTask) {
        //return Integer.compare(this.taskNumber, otherTask.taskNumber); //если нужно преобразовать в integer
        return this.taskNumber-otherTask.getTaskNumber();
    }
}
