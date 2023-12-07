package practice.review;

import practice.review.model.Review;

import java.util.ArrayList;
import java.util.List;

public class RatingAppl {
//- список продуктов, отсортированный по их рейтингу;
//- список продуктов, отсортированный по количеству отзывов на них;
//- список авторов, отсортированный по количеству лайков под их отзывами.
    public static void main(String[] args) {
        List<String> products = new ArrayList<String>();
        products.add("Product 1");
        products.add("Product 2");
        products.add("Product 3");
        products.add("Product 4");

        // Создаем список отзывов
        List<Review> reviews = new ArrayList<Review>();
        reviews.add(new Review(10, "comment1", "Author1", "Product 1", 10));
        reviews.add(new Review(9, "comment2", "Author2", "Product 1", 20));
        reviews.add(new Review(8, "comment3", "Author3", "Product 2", 30));
        reviews.add(new Review(7, "comment4", "Author4", "Product 2", 40));
        reviews.add(new Review(6, "comment5", "Author5", "Product 3", 50));
        reviews.add(new Review( 5, "comment6", "Author6", "Product 3", 60));
        reviews.add(new Review( 4, "comment7", "Author7", "Product 4", 70));
        reviews.add(new Review( 3, "comment8", "Author8", "Product 4", 80));
        reviews.add(new Review( 2, "comment9", "Author9", "Product 4", 90));
        reviews.add(new Review( 1, "comment10", "Author10", "Product 4", 100));




    }
}
