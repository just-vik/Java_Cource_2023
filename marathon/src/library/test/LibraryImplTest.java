package library.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import library.dao.Library;
import library.dao.LibraryImpl;
import library.model.Book;

import static org.junit.jupiter.api.Assertions.*;

class LibraryImplTest {
    Library library;
    Book[] book;


    @BeforeEach
    void setUp() {
        library = new LibraryImpl(4);
        book = new Book[3];

        book[0] = new Book(100, "Kathy Sierra & Bert Bates", "Head First Java", 2003);
        book[1] = new Book(101, "Herbert Schildt", "Java: A Beginner’s Guide", 2020);
        book[2] = new Book(102, "Lasse Koskela", "Test Driven: TDD and Acceptance TDD for Java Developers", 2007);

        //добавим элементы массива в library
        for (int i = 0; i < book.length; i++) {
            library.addBook(book[i]);
        }
    }

    @Test
    void addBook() {
        // не можем добавить null
        assertFalse(library.addBook(null));
        // не можем добавить 2ой раз уже существующий
        assertFalse(library.addBook(book[1]));
        // создаем и добавляем книгу
        Book b1 = new Book(103, "Author", "Title", 2000);
        assertTrue(library.addBook(b1));
        // проверяем кол-во книг после добавления
        assertEquals(4, library.quantity());
        // проверяем что не можем превысить capacity
        Book b2 = new Book(105, "Author2", "Title2", 2000);
        assertFalse(library.addBook(b2));
    }

    @Test
    void removeBook() {
        // удаляем книгу
        assertEquals(book[1], library.removeBook(101));
        // проверяем книг после удаления
        assertEquals(2, library.quantity());
        // проверяем, можем ли удалить дважды
        assertNull(library.removeBook(101));
        // проверяем повторным поиском, что не возможно найти после удаления - вернется null
        assertNull(library.removeBook(101));
    }

    @Test
    void findBook() {
        // ищем книгу по isbn
        assertEquals(book[2], library.findBook(102));
        // ищем несуществующую книгу
        assertNull(library.findBook(104));
    }

    @Test
    void findBooksByAuthor() {
        Book[] booksByAuthor1 = library.findBooksByAuthor("Lasse Koskela");
        assertEquals(3, booksByAuthor1.length);

    }

    @Test
    void quantity() {
        library.printBooks();
    }

    @Test
    void printBooks() {
        library.printBooks();
    }
}