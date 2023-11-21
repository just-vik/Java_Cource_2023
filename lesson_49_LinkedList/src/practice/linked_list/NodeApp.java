package practice.linked_list;

import java.util.LinkedList;

public class NodeApp {
    public static void main(String[] args) {

        // создадим список из целых чисел
        NodeListImpl<Integer> listNumbers = new NodeListImpl<>();
        System.out.println(listNumbers.size());
        System.out.println(listNumbers.isEmpty());//спрашиваем пустой ли он

        listNumbers.add(100);
        listNumbers.add(200);
        listNumbers.add(300);
        listNumbers.add(400);

        System.out.println(listNumbers.size());
        System.out.println(listNumbers.isEmpty());

        for (Integer n : listNumbers) {
            System.out.println(n);
        }

        System.out.println();
        // вставить 250 под индексов 2
        listNumbers.add(2, 250);
        display(listNumbers);
        // удалить узел 300 по индексу 2
        listNumbers.remove(3);
        display(listNumbers);
        // добавить null
        listNumbers.add(4,null);
        display(listNumbers);

        // создадим список из строк


    }

    private static <E> void display(NodeListImpl<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
        System.out.println();
    }

}
