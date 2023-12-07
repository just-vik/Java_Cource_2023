package homework.review_levelup.dao;

public enum MenuOption {
    DISPLAY_PRODUCTS(1, "Печать продуктов"),
    ADD_REVIEW(2, "Добавить отзыв"),
    ADD_LIKE(3, "Поставить лайк отзыву"),
    GET_ANALYTICS(4, "Аналитика"),
    EXIT(5, "Выйти");

    private final int value;
    private final String description;


    MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static void displayMenu() {
        System.out.println("Меню:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.value + ". " + option.description);
        }
    }

    public static MenuOption valueOf(int choice) {
        for (MenuOption option : MenuOption.values()) {
            if (option.value == choice) {
                return option;
            }
        }
        throw new IllegalArgumentException("Неверный выбор.");
    }
}
