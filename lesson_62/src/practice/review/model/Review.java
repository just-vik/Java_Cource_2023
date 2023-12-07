package practice.review.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Review {
    private final long id;
    private int rating;
    private String author;
    private String comment;
    private String product;
    private int likes;
    private final LocalDateTime date;

    private static final AtomicLong idGenerator = new AtomicLong(System.currentTimeMillis());
    //создаем переменную idGenerator типа AtomicLong(генерация уникальных id)
    //и переводим значением текущего времени в миллисекунды.
    public Review(int rating, String comment, String author, String product) {
        this.id = idGenerator.incrementAndGet();
        this.rating = rating;
        this.comment = comment;
        this.author = author;
        this.product = product;
        this.likes = (int) (Math.random() * 41) + 10;//Math.random() - генерируем случайные числа лайков от 10 до 50
        this.date = LocalDateTime.now(); //присваиваем полю date значения текущей даты и времени (LocalDateTime.now())
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public String getProduct() {
        return product;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public int addLike() {
//        return ++likes;
//    }  //нужен ли данный метод???

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", product='" + product + '\'' +
                ", likes=" + likes +
                ", date=" + date +
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
}
