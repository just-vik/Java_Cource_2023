package practice.hashset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class IHashSet<E> implements ISet<E> {
    //field


    private LinkedList<E>[] hashset;//массив из связанных листов,
    //т.е каждый элемент массива это отдельный LinkedList<E>
    private int size;
    private int capacity; //кол-во ячеек
    private double loadFactor; //объем загрузки этих ячеек

    public IHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashset = new LinkedList[capacity]; //
    }

    //в этом конструкторе можно определить свой loadFactor
    public IHashSet(int capacity) {
        this(capacity, 0.75); // 3/4(0.75) по глубине можем загрузить на 75%
    }

    //конструктор по умолчанию
    public IHashSet() {
        this(16, 0.75);
    }

    @Override
    public boolean add(E element) {
        if (size >= capacity * loadFactor) {
            rebuildArray();
        }
        int index = getIndex(element);
        if (hashset[index] == null) {
            hashset[index] = new LinkedList<>();
        }
        if (hashset[index].contains(element)) {
            return false;
        }
        hashset[index].add(element);
        size++;
        return true;
    }

    private void rebuildArray() {
        capacity *= 2;
        //удвоили размер capacity
        LinkedList<E>[] newHashSet = new LinkedList[capacity];
        //надо обежать весь hashSet, залезть в каждый его LinkedList
        //а элементы переложить в новый
        for (LinkedList<E> list : hashset) {
            {//обегаем старый массив
                if (list != null) {
                    for (E e : list) {
                        int index = getIndex(e);
                        if (newHashSet[index] == null) {
                            newHashSet[index] = new LinkedList<>();//создаем новый лист
                        }
                        newHashSet[index].add(e);//перекладываем в новый
                    }
                }
            }
            hashset = newHashSet; //переопределяем ссылку, garbage collector очистит память
        }
    }

    private int getIndex(E element) {
        int hashcode = element.hashCode();//вычисляем hashcode элемента множества
        hashcode = hashcode >= 0 ? hashcode : -hashcode; //если hashcode >= 0 то возвращаем hashcode иначе возвращаем -hashcode (минусовое значение)
        return hashcode % capacity;//деление с остатком
    }

    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        return hashset[index].contains(element);//проверяем наличие элемента
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(element);
        if (res) {
            size--;
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            Iterator<E> listIterator = (hashset[index] != null) ? hashset[index].iterator() : null;

            @Override
            public boolean hasNext() {
                while ((listIterator == null || !listIterator.hasNext()) && index < capacity - 1) {
                    index++;
                    listIterator = (hashset[index] != null) ? hashset[index].iterator() : null;
                }
                return listIterator != null && listIterator.hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return listIterator.next();
            }
        };


        /*
        return new Iterator<E>() {
            int i;
            int j;
            int totalCounter;

            @Override
            public boolean hasNext() {
                return totalCounter < size; //
            }

            @Override
            public E next() {
                while (hashset[i] == null || hashset[i].isEmpty()) {//если пуста
                    i++;//переходим к следующему
                }
                E res = hashset[i].get(j);
                totalCounter++;
                if (j < hashset[i].size() - 1) {//находимся внутри LinkedList
                    j++;
                }else {
                    j=0;
                    i++;
                }
                return res;
            }
        };

         */
    }
}
