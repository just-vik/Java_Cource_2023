package homework.todolist_file.model;

public enum Menu {
    ADD(1, "Add task"),
    LIST(2, "List of tasks"),
    REMOVE(3, "Remove task"),
    SAVE(4,"Save task"),
    EXIT(5, "Exit");

    //fields
    private int menuItem;
    private String action;

    // constructor
    Menu(int menuItem, String action) {
        this.menuItem = menuItem;
        this.action = action;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public String getAction() {
        return action;
    }

    public static void printMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getMenuItem() + " - " + menu.getAction().toUpperCase());
        }
        //для замены добавляем нужные сеттеры
        System.out.println(); // new line
    }
}
