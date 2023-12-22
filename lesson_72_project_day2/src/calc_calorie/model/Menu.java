package calc_calorie.model;

public enum Menu {

    // todo пункты меню
    ADD(1, "Add your product"),
    LIST(2, "Your list products by period"),
    REMOVE(3, "Remove product"),
    SAVE(4,"Save added product to file"),
    LOAD(5,"Load added product from file"),
    EXIT(6, "Exit");

    //fields
    private final int menuItem;
    private final String action;

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
        System.out.println("Menu: ");
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getMenuItem() + " - " + menu.getAction());
        }
        System.out.println("Choose an option: ");
    }
}
