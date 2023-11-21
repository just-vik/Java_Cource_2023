package homework.book;

import homework.book.model.Dictionary;

public class BookAppl {
    public static void main(String[] args) {
        Dictionary dictionary1=new Dictionary("'Мастер и маргарита'","Булгаков М.А.",1966,"0-14-118014-5","Novel",480);
        Dictionary dictionary2=new Dictionary("'Sapiens: A Brief History of Humankind'","Yuval Noah Harari",2011,"978-0062316097","Non-fiction",464);

        dictionary1.display();
        dictionary1.displayDict();
        System.out.println("----------------------------------");
        dictionary2.display();
        dictionary2.displayDict();
    }
}
