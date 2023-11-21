package homework.book;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookApp {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(111, "Author2", "FANTASY", 2015));
        bookList.add(new Book(222, "Author1", "ADVENTURE", 2020));
        bookList.add(new Book(333, "Author3", "BIOGRAPHY", 2023));
        bookList.add(new Book(444, "Author4", "DOCUMENTARY", 2023));
        bookList.add(new Book(555, "Author7", "HORROR", 2023));
        bookList.add(new Book(666, "Author6", "ADVENTURE", 2023));

        System.out.println("-------------Added new book----------------");
        //создали
        Book book = new Book(777, "Author5", "DRAMA", 2008);
        //добавили в список
        bookList.add(book);

        System.out.println("------------Collections sort----------------");
        Collections.sort(bookList);// Collections класс, включающий в себя sort()метод сортировки списков по алфавиту или по номеру
        // печатаем
        for (Book b : bookList) {
            System.out.println(b);
        }

        System.out.println("------------ Get --------------");
        //доступ к элементу через индекс
        System.out.println(bookList.get(0));

        System.out.println("------------ Set --------------");
        //изменяем элемент по его индексу
        Book newBook = new Book(888, "NewAuthor", "FICTION", 2000);
        bookList.set(0, newBook);
        System.out.println("Update books: ");
        // печатаем
        for (Book b : bookList) {
            System.out.println(b);
        }

        System.out.println("------------ Remote by index --------------");
        //удаляем 1 элемент по его индексу
        bookList.remove(0);
        for (Book b : bookList) {
            System.out.println(b);
        }

        System.out.println("------------ Clear all books --------------");
        //удаляем все элементы массива
        bookList.clear();
        System.out.println(bookList);


    }


}
