package practice.to_do_list.model;

//1. Использовать enum для организации меню (номер пункта, действие) приложения:
// - добавить запись
// - посмотреть все записи
// - удалить запись (по номеру)
// - выйти
//2. Реализовать метод printMenu().

public enum Menu {
    ADD(1, "Add task"),
    VIEW(2, "View tasks"),
    DEL(3, "Delete task"),
    EXIT(4, "Exit");

    private int number;
    private String action;

    Menu(int number, String action) {
        this.number = number;
        this.action = action;
    }

    public int getNumber() {
        return number;
    }

    public String getAction() {
        return action;
    }

    public static void printMenu() {
        System.out.println("Menu: ");
        for (Menu option : Menu.values()) { //начинается цикл, который позволяет нам перебирать все элементы в "Menu"
            System.out.println(option.number + ". " + option.action);
        }
        System.out.print("Choose action: ");
    }
}
