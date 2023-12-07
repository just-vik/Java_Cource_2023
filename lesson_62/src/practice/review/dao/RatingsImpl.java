package practice.review.dao;

import practice.review.model.Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class RatingsImpl implements Rating {
//    Реализуйте приложение "Reviews" согласно UML-схеме.
//    Создайте приложение, в котором задайте несколько отзывов (порядка 10) на несколько продуктов (3-4 продукта).
//    Каждый автор может оставить только один отзыв на каждый продукт. Отзывы получили случайное число лайков
//    от посетителей сайта в интервале от 10 до 50.
//    Рассчитайте рейтинг продуктов на основании оценок в отзывах на эти продукты.
//    Получите также:
//- список продуктов, отсортированный по их рейтингу;
//- список продуктов, отсортированный по количеству отзывов на них;
//- список авторов, отсортированный по количеству лайков под их отзывами.

    Collection<Review> reviews;

    public RatingsImpl() {
        reviews = new HashSet<>();
    }

    public RatingsImpl(List<Review> reviews) {
        this();
        reviews.forEach(this::add);
    }


    @Override
    public boolean add(Review review) {
        return review != null && reviews.add(review);
    }

    @Override
    public boolean remove(Long id) {
        //удаление элемента из множества
        for (Review review : reviews) {//проходим по всем элементам коллекции
            if (review.getId() == id) {//если id элемента равен заданному id
                return reviews.remove(review);//удаляем элемент из коллекции
            }
        }
        return false;//если не нашли элемент с заданным id, то возвращаем false
    }


    @Override
    public boolean update(Long id, int newRating) {
        for (Review review : reviews) {
            if (review.getId() == id) {
                return review.setRating(newRating);
            }
        }
        return false;
    }

    @Override
    public Iterable<Review> getReviewByProduct(String product) {
//        List<Review> reviews = new ArrayList<>();
//        for (List<Review> productReviews : productReviews.values()) {
//            for (Review review : productReviews) {
//                if (review.getProduct().equals(product)) {
//                    reviews.add(review);
//                }
//            }
//        }
//        return reviews;
//        return reviews.stream()
//                .filter(review -> review.getProduct().equals(product))
//                .collect(Collectors.toList());
        return reviews.stream()
                .filter(review -> review.getProduct().equals(product))
                .toList()
                .isEmpty() ? null : reviews.stream()
                .filter(review -> review.getProduct().equals(product))
                .toList();
    }

    @Override
    public Iterable<Review> getReviewByAuthor(String author) {
        return reviews.stream()
                .filter(review -> review.getAuthor().equals(author))
                .toList()
                .isEmpty() ? null : reviews.stream()
                .filter(review -> review.getAuthor().equals(author))
                .toList();
    }

    @Override
    public double getAvgRatingByProduct(String product) {
        return product == null ? 0 : reviews.stream()
                .filter(review -> review.getProduct().equals(product))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);
    }

    @Override
    public Iterable<Review> getReviewWithMaxLikes() {
        int maxLikes = reviews.stream()
                .mapToInt(Review::getLiked)
                .max()
                .orElse(0);

        return reviews.stream()
                .filter(review -> review.getLiked()==maxLikes)
                .toList();
    }
}
