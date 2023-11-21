package homework.article_arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Article {
    public static void main(String[] args) {
        ArrayList<String> cars =new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);

        System.out.println("------------Collections sort----------------");
        Collections.sort(cars);// Collections класс, включающий в себя sort()метод сортировки списков по алфавиту или по номеру
        System.out.println(cars);

        System.out.println("------------fori----------------");
        //перебор элементов массива через fori
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        System.out.println("------------for-each----------------");
        //...........через цикл цикл for-each
        for (String i : cars) {
            System.out.println(i);
        }


        System.out.println("------------other actions----------------");
        //доступ к элементу через индекс
        System.out.println(cars.get(0));
        //изменяем элемент по его индексу
        cars.set(0, "Opel");
        System.out.println(cars.get(0));
        //удаляем 1 элемент по его индексу
        cars.remove(0);
        System.out.println(cars);
        //удаляем все элементы массива
        cars.clear();
        System.out.println(cars);

        System.out.println("------------New Array----------------");
// использование объектов другого типа через указание эквивалентного класса-оболочки
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);
        Collections.sort(myNumbers);// Сортировка ArrayList целых чисел
        for (int i : myNumbers) {
            System.out.println(i);
        }


    }
}
