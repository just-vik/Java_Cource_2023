package practice.linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class NodeListImpl<E> implements NodeList<E> {
    //fields
    private Node<E> first;
    private Node<E> last;
    int size;


    @Override
    public int size() { //Computational complexity of methods
        return size;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, element, null); // создаем новый, следующий узел, он последний
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;// если список был пустой, то новый создаваемый элемент становится первым
        }
        last = newNode;
        size++;
        return true;
        // узел новый, следующий, в конец списка
    }

    @Override
    public void clear() {
//        Node<E> node = first;
//        while (node != null) {
//            Node<E> next = node.next;
//            node.data = null;
//            node.next = null;
//            node.prev = null;
//            node = next;
//        }
        first = last = null;
        size = 0;

    }

    @Override
    public boolean add(int index, E element) {
        if (index == size) { //добавление элемента в конец
            return add(element);
        }
        Node<E> node = getNodeByIndex(index); // берем узел по его индексу
        Node<E> newNode = new Node<>(node.prev, element, node); //создаем новый узел для вставки в середину списка
        node.prev = newNode;
        if (index != 0) {
            newNode.prev.next = newNode;
        } else {
            first = newNode; //вставка в самое начало списка
        }
        size++;
        return true;
    }

    //TODO разобраться как работает метод
    private Node<E> getNodeByIndex(int index) { //Объявление метода. Он принимает индекс в качестве аргумента и возвращает узел списка с типом E.
        checkIndex(index); //вызов метода checkIndex, который проверяет корректность значения индекса (например, находится ли индекс в пределах списка).
        Node<E> node; //объявление переменной node, которая будет использоваться для хранения найденного узла.
        //блок кода if(){} else {} отвечает за определение того, с какого конца списка начать итерацию для поиска узла.
        //Если индекс меньше половины размера списка, то начинается поиск с головы (first).
        //В противном случае, начинается с хвоста (last). Далее происходит итерация по списку:
        // если индекс меньше половины размера списка, узел перемещается вперед по ссылке node.next,
        // пока не будет достигнут нужный индекс. В случае, если индекс больше половины размера списка,
        // узел перемещается назад по ссылке node.prev, также до достижения нужного индекса.
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node; //завершает метод, возвращая найденный узел по указанному индексу.
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) { //внутри узла не null
            for (Node<E> node = first; node != null; node = node.next, index++) { // цикл перебирает узлы
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {  //внутри узла null
            for (Node<E> node = first; node != null; index++) {
                if (o == node.data) { // null можно сравнивать через ==
                    return index;
                }
            }
        }
        return -1; //объект о не найден
    }

    @Override
    public int lastIndexOf(Object o) {  //TODO
//        int index = size;
//        if (o == null) {
//            for (LinkedList.Node<E> x = last; x != null; x = x.prev) {
//                index--;
//                if (x.item == null)
//                    return index;
//            }
//        } else {
//            for (LinkedList.Node<E> x = last; x != null; x = x.prev) {
//                index--;
//                if (o.equals(x.item))
//                    return index;
//            }
//        }
//        return -1;
        return 0;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        return unlink(node);
    }

    // TODO разобраться самостоятельно что делает метод
    private E unlink(Node<E> node) {
        E victim = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
            node.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            node.next = null;
        } else {
            last = prev;
        }
        node.data = null;
        size--;
        return victim;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index); //нашли узел по индексу
        E victim = node.data;
        node.data = element; // обновили данные
        return victim;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = first;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E data = currentNode.data;
                currentNode=currentNode.next;
                return data;
            }
        };
    }
}
