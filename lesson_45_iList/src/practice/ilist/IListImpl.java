package practice.ilist;

import java.util.Arrays;
import java.util.Iterator;

public class IListImpl<E> implements IList<E> {

    //fields
    private Object[] elements; //массив для списка объектов
    private int size; // его размер

    //================================================================================================
    //constructor
    public IListImpl(int initialCapacity) {
        //если прислали отрицательное значение initialCapacity
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);//выбрасываем исключение
        }
        elements = new Object[initialCapacity];
    }

    public IListImpl() {
        this(10);
    }
    //================================================================================================

    @Override
    public int size() {
        return size;
    }

    //================================================================================================
    @Override
    public void clean() {
        //for (Object element : elements) {  // реализация через foreach
        // elements.clear();
        //size = 0;
        //  }
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    //================================================================================================
    @Override
    public boolean add(E element) {
        ensureCapacity(); //добавляем метод - реализуем ниже
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() { // метод обеспечения необходимого capacity
        if (size == elements.length) {
            if (size == Integer.MAX_VALUE) {
                throw new OutOfMemoryError(); //большего по размеру массива создать не можем
            }
            // считаем capacity
            int newCapacity = elements.length + elements.length / 2; //вырастили длину массива в 1.5 раза
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    //================================================================================================
    @Override
    public boolean add(int index, E element) {
        if (index == size) { // добавление в конец списка(массив)
            add(element);
            return true;
        }
        // добавление в середину списка
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size++ - index);
        elements[index] = element;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index); // Исключение выхода индекса за пределы
        }
    }

    //================================================================================================
    @Override
    public E removeByIndex(int index) {
        checkIndex(index);
        E el = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        elements[size] = null; // зачем затираем последний элемент
        return el;
    }
    // После выполнения System.arraycopy, когда элементы сдвигаются на одну позицию назад,
    // последний элемент становится дублированным на предпоследней позиции.
    // Затирание последнего элемента elements[size] = null; выполняется для очистки этой дублированной позиции,
    // иначе в списке может остаться ссылка на ненужный объект, что может вызвать утечку памяти.
    // Этот шаг необходим для правильной работы списка и предотвращения утечек памяти.
    // В Java объекты не удаляются сразу после вызова remove, и сборка мусора может произойти позже.
    // Поэтому затирание последнего элемента является хорошей практикой для избежания утечек памяти.

    //================================================================================================
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index]; // (E) кастинг к типу
    }

    //================================================================================================
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E victim = (E) elements[index]; // нашли элемент по индексу
        elements[index] = element;
        return victim;
    }

    //================================================================================================
    @Override
    public int indexOf(Object o) {
        if (o != null) { //когда объект не null
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else { // когда в листе ест объект null
            for (int i = 0; i < size; i++) {
                if (null == (elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //================================================================================================
    @Override
    public int lastIndex(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    //================================================================================================
    @Override
    public Iterator<E> iterator() {
        // Создание нового анонимного класса, реализующего интерфейс Iterator<E>
        return new Iterator<E>() {
            int i = 0; // Индекс текущего элемента, с которого начинается перебор

            @Override
            public boolean hasNext() {
                // Проверка, есть ли следующий элемент для перебора
                return i < size;
            }

            @Override
            public E next() {
                // Возвращение следующего элемента и сдвиг курсора на один элемент вперед
                return (E) elements[i++]; //чтобы итератор двигался нужно курсор сдвигать [i++]
            }
        };
    }
}
