package practice.review.model;


import java.time.LocalDateTime;
import java.util.Objects;

public class Review implements Comparable<Review> {
    //field
    long id;
    int rating;
    String comment;
    String author;
    String product;
    int liked;
    LocalDateTime data;

    //constructor

    public Review(int rating, String comment, String author, String product, int liked) {
        this.rating = rating;
        this.comment = comment;
        this.author = author;
        this.product = product;
        this.liked = liked;
    }


    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public String getProduct() {
        return product;
    }

    public int getLiked() {
        return liked;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review { " +
                "id = " + id +
                ", rating = " + rating +
                ", comment = '" + comment + '\'' +
                ", author = '" + author + '\'' +
                ", product = '" + product + '\'' +
                ", liked = " + liked +
                ", data = " + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static int addLike(int like) {
        return like++;
    }

    @Override
    public int compareTo(Review o) {
        return this.data.compareTo(o.data);
    }

    public boolean setRating(int newRating) {
        this.rating = newRating;
        return false;
    }
}

