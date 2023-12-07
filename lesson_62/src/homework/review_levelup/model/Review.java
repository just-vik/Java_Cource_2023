package homework.review_levelup.model;


import java.time.LocalDateTime;
import java.util.Objects;

public class Review implements Comparable<Review> {
    private static int idCounter = 1; //счетчик ID

    //field
    long id;
    int rating;
    String comment;
    String author;
    String product;
    int liked;
    LocalDateTime data;

    //constructor


    public Review(int rating, String comment, String author, String product, LocalDateTime data) {
        this.id = idCounter++;
        this.rating = rating;
        this.comment = comment;
        this.author = author;
        this.product = product;
        this.liked = liked;
        this.data = data;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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

