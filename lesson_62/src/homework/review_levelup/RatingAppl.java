package homework.review_levelup;

import homework.review_levelup.dao.MenuOption;
import homework.review_levelup.model.Review;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class RatingAppl {
    private static final List<Review> reviews = new ArrayList<>();
    private static final List<String> availableProducts = Arrays.asList("Футболка", "Платье", "Джинсы", "Куртка");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MenuOption.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (MenuOption.valueOf(choice)) {
                case DISPLAY_PRODUCTS:
                    displayProducts();
                    break;
                case ADD_REVIEW:
                    addReview(scanner);
                    break;
                case ADD_LIKE:
                    addLike(scanner);
                    break;
                case GET_ANALYTICS:
                    getAnalytics();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void displayProducts() {
        System.out.println("Продукты:");
        for (String product : availableProducts) {
            System.out.println("Продукт: " + product);

            // Фильтрация отзывов для данного продукта
            List<Review> productReviews = reviews.stream()
                    .filter(review -> review.getProduct().equals(product))
                    .collect(Collectors.toList());

            // Вывод отзывов и их количество лайков
            for (int i = 0; i < productReviews.size(); i++) {
                Review review = productReviews.get(i);
                System.out.println((i + 1) + ". Отзыв: " + review.getComment() + " Автор: " + review.getAuthor() +" | Количество лайков: " + review.getLiked());
            }

            System.out.println();
        }
    }

    // Добавление нового отзыва
    private static void addReview(Scanner scanner) {
        System.out.println("Выберите продукт:");
        displayAvailableProducts();
        int productChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите комментарий:");
        String comment = scanner.nextLine();

        System.out.println("Введите автора:");
        String author = scanner.nextLine();

        System.out.println("Введите оценку (от 1 до 10):");
        int rating = scanner.nextInt();
        scanner.nextLine();


        if (productChoice >= 0 && productChoice < availableProducts.size()) {
            String product = availableProducts.get(productChoice);
            reviews.add(new Review(rating, comment, author, product, LocalDateTime.now()));
            System.out.println("Отзыв успешно добавлен!");
        } else {
            System.out.println("Неверный выбор продукта.");
        }
    }

    // Постановка лайка отзыву
    private static void addLike(Scanner scanner) {
        System.out.println("Выберите продукт:");

        // Печать отзывов и продуктов для выбора с использованием foreach
        int index = 0;
        for (Review review : reviews) {
            System.out.println(index + ". " + review.getProduct() + " - " + review.getComment());
            index++;
        }

        // Запрос ввода номера отзыва
        System.out.println("Введите номер отзыва, к которому хотите поставить лайк:");
        int reviewNumber = scanner.nextInt(); // Читаем номер отзыва
        scanner.nextLine(); // Считываем оставшийся перевод строки

        if (reviewNumber >= 0 && reviewNumber < reviews.size()) {
            Review review = reviews.get(reviewNumber); // Получаем отзыв по номеру
            review.setLiked(review.getLiked() + 1); // Увеличиваем количество лайков
            System.out.println("Лайк успешно поставлен!");
        } else {
            System.out.println("Отзыва с таким номером не существует!");
        }
    }

    private static void getAnalytics() {
        // получения статистики по отзывам
        Map<String, Double> avgRatingsByProduct = reviews.stream()
                .collect(Collectors.groupingBy(Review::getProduct,
                        Collectors.averagingInt(Review::getRating)));

        Map<String, Long> reviewCountByProduct = reviews.stream()
                .collect(Collectors.groupingBy(Review::getProduct, Collectors.counting()));

        Map<String, Integer> likesByAuthor = reviews.stream()
                .collect(Collectors.groupingBy(Review::getAuthor,
                        Collectors.summingInt(Review::getLiked)));

        displaySortedResults("Список продуктов, отсортированный по рейтингу:",
                getSortedProductsByRating());

        displaySortedResults("Список продуктов, отсортированный по количеству отзывов:",
                reviewCountByProduct.entrySet().stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()));

        displaySortedResults("Список авторов, отсортированный по количеству лайков под их отзывами:",
                likesByAuthor.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()));
    }

    private static void displaySortedResults(String message, List<String> results) {
        System.out.println(message);
        results.forEach(System.out::println);
    }

    private static List<String> getSortedProductsByRating() {
        // список продуктов, отсортированных по рейтингу
        return reviews.stream()
                .collect(Collectors.groupingBy(Review::getProduct,
                        Collectors.averagingInt(Review::getRating)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void displayAvailableProducts() {
        System.out.println("Доступные продукты:");
        for (int i = 0; i < availableProducts.size(); i++) {
            System.out.println(i + ". " + availableProducts.get(i));
        }
    }
}