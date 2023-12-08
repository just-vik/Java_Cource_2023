package practice.review.dao;

import practice.review.model.Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class RatingsImpl implements Rating {

    private final Collection<Review> reviews; //объявляем переменную для хранения отзывов

    public RatingsImpl() {
        this.reviews = new ArrayList<>(); //инициализируем переменную reviews как ArrayList
    }

    @Override
    public boolean add(Review review) {
        return review != null && reviews.add(review); //добавление отзыва в коллекцию, если отзыв не null
    }

    @Override
    public boolean remove(long id) {
        return reviews.removeIf(review -> review.getId() == id); //удаление отзыва по заданному id
    }

    @Override
    public boolean update(long id, int newRating) {
        return reviews.stream() //создаем поток отзывов
                .filter(review -> review.getId() == id) //фильтруем отзывы по id
                .findFirst() //получаем первый отзыв
                .map(review -> review.setRating(newRating)) //устанавливаем новый рейтинг, если отзыв найден
                .orElse(false); //возвращаем false, если отзыв не найден
    }

    @Override
    public List<Review> getReviewsByProduct(String product) {
        return reviews.stream() //создаем поток отзывов
                .filter(review -> review.getProduct().equals(product)) //фильтруем отзывы по продукту
                .collect(Collectors.toList()); //преобразовываем отзывы в List
    }

    @Override
    public List<Review> getReviewsByAuthor(String author) {
        return reviews.stream()
                .filter(review -> review.getAuthor().equals(author)) //фильтруем отзывы по автору
                .collect(Collectors.toList()); //преобразовываем отзывы в List
    }

    @Override
    public double getAvgRatingByProduct(String product) {
        List<Review> productReviews = reviews.stream()
                .filter(review -> review.getProduct().equals(product)) //фильтруем отзывы по продукту
                .collect(Collectors.toList());

        if (!productReviews.isEmpty()) { //проверяем что список отзывов по продукту не пуст
            double sum = productReviews.stream().mapToInt(Review::getRating).sum(); //вычисляем сумму рейтингов
            return sum / productReviews.size(); //считаем среднее значение рейтинга
        }

        return 0; //возвращаем 0, если нет отзывов
    }

    @Override
    public List<Review> getReviewWithMaxLikes() {
        int maxLikes = reviews.stream()
                .mapToInt(Review::getLikes) //преобразовываем в поток int рейтингов
                .max() //максимального значения рейтинга
                .orElse(0); // 0, если нет отзывов

        return reviews.stream()
                .filter(review -> review.getLikes() == maxLikes) //фильтруем отзывы по максимальному рейтингу
                .collect(Collectors.toList());
    }
}

