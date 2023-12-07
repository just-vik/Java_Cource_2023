package practice.review;

import practice.review.dao.Rating;
import practice.review.dao.RatingsImpl;
import practice.review.model.Review;

import java.util.*;
import java.util.stream.Collectors;

public class RatingAppl {
    public static void main(String[] args) {
        Rating ratings = new RatingsImpl();

        String[] products = {"Рубашка", "Платье", "Джинсы", "Куртка"};
        String[] authors = {"Автор 1", "Автор 2", "Автор 3", "Автор 4"};

        List<Review> generatedReviews = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String product = products[i % products.length];
            String author = authors[i % authors.length];
            int rating = (int) (Math.random() * 5) + 1;
            String comment = "Пример комментария " + i;

            Review review = new Review(rating, comment, author, product);
            ratings.add(review);
            generatedReviews.add(review); // Добавляем отзыв для печати
        }

        System.out.println("Отзывы:");
        for (Review review : generatedReviews) {
            System.out.println(review);
        }
        System.out.println();

        // Задача 1: Рассчитать рейтинг продуктов на основании оценок в отзывах
        List<String> productsSortedByRating = getProductsSortedByRating(ratings);
        System.out.println("Список продуктов [сортировка по рейтингу]: " + productsSortedByRating);

        // Задача 2: Список продуктов, отсортированный по количеству отзывов на них
        List<String> productsSortedByNumberOfReviews = getProductsSortedByNumberOfReviews(ratings);
        System.out.println("Список продуктов, [сортировка по кол-ву отзывов]: " + productsSortedByNumberOfReviews);

        // Задача 3: Список авторов, отсортированный по количеству лайков под их отзывами
        List<String> authorsSortedByLikes = getAuthorsSortedByLikes(ratings);
        System.out.println("Список авторов, [сортировка по кол-ву лайков под их отзывами]: " + authorsSortedByLikes);
    }

    private static List<String> getProductsSortedByRating(Rating ratings) {
        //Map для хранения рейтингов продуктов
        Map<String, Double> productRatings = new HashMap<>();
        //Проходимся по всем отзывам, полученным через метод getReviewWithMaxLikes
        for (Review review : ratings.getReviewWithMaxLikes()) {
            //Получаем текущий рейтинг продукта из Map или 0, если его нет
            double currentRating = productRatings.getOrDefault(review.getProduct(), 0.0);
            //Рассчитываем новый рейтинг для продукта на основе текущего рейтинга и нового отзыва
            double newRating = (currentRating * productRatings.size() + review.getRating()) / (productRatings.size() + 1);
            //Обновляем рейтинг продукта в Map
            productRatings.put(review.getProduct(), newRating);
        }
        //Сортируем записи Map по значение(рейтинг) в убывающем порядке,
        //затем извлекаем ключи (названия продуктов) и помещаем их в список
        return productRatings.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> getProductsSortedByNumberOfReviews(Rating ratings) {
        //Создаем Map для хранения количества отзывов по продуктам
        Map<String, Long> productReviewCount = new HashMap<>();
        //Проходимся по всем отзывам, полученным через метод getReviewWithMaxLikes
        for (Review review : ratings.getReviewWithMaxLikes()) {
            //Получаем текущее количество отзывов по продукту из Map или 0, если его нет
            long currentCount = productReviewCount.getOrDefault(review.getProduct(), 0L);
            //Увеличиваем количество отзывов по продукту на 1 и обновляем в Map
            productReviewCount.put(review.getProduct(), currentCount + 1);
        }
        //Сортируем записи Map по значению (количеству отзывов) в убывающем порядке,
        //затем извлекаем ключи (названия продуктов) и помещаем их в список
        return productReviewCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> getAuthorsSortedByLikes(Rating ratings) {
        //Создаем Map для хранения лайков по авторам отзывов
        Map<String, Integer> authorLikes = new HashMap<>();
        //Проходимся по всем отзывам, полученным через метод getReviewWithMaxLikes
        for (Review review : ratings.getReviewWithMaxLikes()) {
            //Получаем текущее количество лайков для автора из Map или 0, если его нет
            int currentLikes = authorLikes.getOrDefault(review.getAuthor(), 0);
            //Увеличиваем количество лайков для автора на количество лайков в текущем отзыве и обновляем в Map
            authorLikes.put(review.getAuthor(), currentLikes + review.getLikes());
        }
        //Сортируем записи Map по значению (количеству лайков) в убывающем порядке,
        //затем извлекаем ключи (имена авторов) и помещаем их в список
        return authorLikes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}