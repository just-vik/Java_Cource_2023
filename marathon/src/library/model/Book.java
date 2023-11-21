package library.model;

public class Book implements Comparable<Book>{
    // ---------- class fields ----------
    private int isbn;
    private String author;
    private String title;
    private int year;


    // ---------- constructor ----------

    public Book(int isbn, String author, String title, int year) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.year = year;
    }


    // ---------- getters & setters ----------

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    // ---------- equals & hashCode ----------


    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("Book ");
        sb.append("isbn = ").append(isbn);
        sb.append(" author = ").append(author).append('\'');
        sb.append(" title = ").append(title).append('\'');
        sb.append(" year = ").append(year);
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        int res = this.year - o.year;
        return res;
    }
}
