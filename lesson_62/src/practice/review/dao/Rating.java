package practice.review.dao;

import practice.review.model.Review;

public interface Rating {
    boolean add (Review review);
    boolean remove(Long id);
    boolean update(Long id, int newRating);
    Iterable<Review> getReviewByProduct(String product);
    Iterable<Review> getReviewByAuthor(String author);
    double getAvgRatingByProduct(String product);
    Iterable<Review> getReviewWithMaxLikes();

}
