package myLinkedList;

/**
 * MyLinkedList — это простая реализация двусвязного списка.
 * Этот класс предоставляет основные функции, такие как добавление, удаление и получение элементов по индексу.
 *
 * @param <E> тип элементов в этом списке
 */

public class MyLinkedList<E> implements MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    /**
     * Конструктор списка, создающий пустой связный список.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец связного списка.
     *
     * @param data элемент, который будет добавлен в список
     * @return true, если элемент был успешно добавлен
     */
    @Override
    public boolean add(E data) {
        MyNode<E> newNode = new MyNode<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;
        return true;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Сдвигает все последующие элементы влево.
     *
     * @param index индекс элемента, который нужно удалить
     * @return элемент, который был удален
     * @throws IndexOutOfBoundsException если индекс находится за пределами допустимого диапазона
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode<E> currentNode = getNode(index);
        E removedData = currentNode.data;
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;  // Если удаляемый элемент — первый
        }

        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;  // Если удаляемый элемент — последний
        }

        size--;
        return removedData;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает элемент, находящийся по указанному индексу.
     *
     * @param index индекс элемента, который нужно вернуть
     * @return элемент, находящийся по указанному индексу
     * @throws IndexOutOfBoundsException если индекс находится за пределами допустимого диапазона
     */
    @Override
    public E getElementByIndex(int index) {
        MyNode<E> currentNode = getNode(index);
        return currentNode.data;
    }

    private MyNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
}
