package homework.documents.model;

//      - добавить документ (запрос id документа, id папки, названия документа, url, присвоение текущей даты и времени)
//        - показать список всех документов в архиве
//        - узнать количество хранимых документов в архиве
//        - выход

public enum MenuDocs {
    ADD(1, "Add document"),
    LIST(2, "List of documents"),
    QUANTITY(3, "Quantity"),
    EXIT(4, "Exit");

    //fields
    private int menuItem;
    private String action;

    // constructor
    MenuDocs(int menuItem, String action) {
        this.menuItem = menuItem;
        this.action = action;
    }

    // метод, void - ничего не возвращает, он печатает
    public static void printMenu(){
        MenuDocs[] menu = MenuDocs.values(); // put enum items into array
        for (int i = 0; i < menu.length; i++) {
            System.out.print((menu[i].menuItem) + " - " + menu[i].action + " | ");
        }
        System.out.println(); // new line
    }
}
