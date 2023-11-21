package practice.linked_list;

public interface NodeList<E> extends Iterable<E> { // <E> параметризован дженериком E
    //объявляем методы
    // default - метод по умолчанию - это метод, определенный в интерфейсе с реализацией по умолчанию.
    int size(); //размер листа

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean add(E element);

    void clear(); //зачистка

    default boolean contains(Object o) {
        return indexOf(o) >= 0; // есть ли такой объект в списке
    }

    default boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;

    /*  int index = indexOf(o);
        if (index<0) {
            return false;
        }
        remove(index);
        return true;
    */
    }

    boolean add(int index, E element); //add перегрузили....добавляем element на место по индексу

    E get(int index); // получение element по индексу

    int indexOf(Object o); // удаление из листа узла по его индексу

    int lastIndexOf(Object o);

    E remove(int index);

    E set(int index, E element);

}
