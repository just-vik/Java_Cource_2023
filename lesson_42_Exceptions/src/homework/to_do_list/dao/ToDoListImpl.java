package homework.to_do_list.dao;

//5. ToDoListImpl - создать, реализовать методы.


import homework.to_do_list.model.Task;

public class ToDoListImpl implements ToDoList {
    private Task[] tasks = new Task[10];
    private int size = 0;


    @Override
    public void addTask(Task task) {
        // Проверяем, есть ли место в массиве 'tasks' для добавления новой задачи.
        if (size < tasks.length) {
            // Если есть место, добавляем задачу в массив на индекс 'size'.
            tasks[size] = task;
            size++; // Увеличиваем размер, чтобы указать, что задача была добавлена.
        }
        // Если в массиве нет места, задача не добавляется.
    }

    @Override
    public void viewTasks() {
        // Проверяем, пуст ли список задач.
        if (size == 0) {
            System.out.println("The task list is empty.");
        } else {
            System.out.println("Task list:");
            // Перебираем массив 'tasks' и выводим каждую задачу.
            for (int i = 0; i < size; i++) {
                System.out.println(tasks[i]);
            }
        }
    }


    @Override
    public void deleteTask(int taskNumber) {
        // Перебираем массив 'tasks' в поисках задачи с указанным номером задачи.
        for (int i = 0; i < size; i++) {
            if (tasks[i].getTaskNumber() == taskNumber) {
                // Если найдена задача с указанным номером, удаляем её из массива.
                for (int j = i; j < size - 1; j++) {
                    tasks[j] = tasks[j + 1]; // Сдвигаем задачи в массиве, чтобы заполнить пустое место.
                }
                size--; // Уменьшаем размер, чтобы указать, что задача была удалена.
                System.out.println("Task deleted.");
                return; // Выходим из метода после удаления задачи.
            }
        }
        // Если задача с указанным номером не найдена, выводим сообщение.
        System.out.println("The task with this number was not found.");
    }

    public int qty() {
        return size;
    }
}
