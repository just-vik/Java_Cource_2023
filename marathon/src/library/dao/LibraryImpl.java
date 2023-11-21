package library.dao;

import library.model.Book;

public class LibraryImpl implements Library {
    // ---------- fields ----------
    private Book[] books;
    private int qty;

    // ---------- constructor ----------
    public LibraryImpl(int capacity) {
        books = new Book[capacity];
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || qty == books.length || findBook(book.getIsbn()) != null) {
            return false;
        }
        books[qty] = book;
        qty++;
        return true;
    }

    @Override
    public Book removeBook(int isbn) {
        for (int i = 0; i < qty; i++) {
            if (books[i].getIsbn() == isbn) {
                Book victim = books[i];
                books[i] = books[qty - 1];
                books[qty-1]=null;
                qty--;
                return victim;
            }

        }
        return null;
    }

    @Override
    public Book findBook(int isbn) {
        for (int i = 0; i < qty; i++) { //пробегает только по заполненным элементам массива которые отражаются в size
            if (books[i].getIsbn() == isbn) { // нашелся элемент массива у которого совпал id
                return books[i]; //вернули найденный элемент
            }
        }
        return null;
    }

    public Book[] findBooksByAuthor(String author) {
        Book[] findBooks = new Book[qty]; // Создаем массив для хранения найденных книг
        int count = 0;
        for (int i = 0; i < qty; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                findBooks[count] = books[i];
                count++;
            }
        }
        return findBooks;
    }



    @Override
    public int quantity() {
        return qty;
    }

    @Override
    public void printBooks() {
        for (int i = 0; i < qty; i++) {
            System.out.println(books[i]);
        }

    }


}
