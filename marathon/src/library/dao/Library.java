package library.dao;

import library.model.Book;

public interface Library {
    //    объявляем методы, только сигнатуры, без тела метода

    boolean addBook(Book book);

    Book removeBook(int isbn);

    Book findBook(int isbn);

    Book[] findBooksByAuthor(String author);

    int quantity();

    void printBooks();

}
