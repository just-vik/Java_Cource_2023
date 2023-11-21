package homework.book.model;

public class Dictionary extends Book {

    private String genres;
    private int pageCount;


    public Dictionary(String title, String author, int year, String isbn, String genres, int pageCount) {
        super(title, author, year, isbn);
        this.genres = genres;
        this.pageCount = pageCount;
    }


    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public void displayDict() {
        System.out.println("The book is written in genre: " + genres + "\nAnd contains " + pageCount + " pages");
    }
}
