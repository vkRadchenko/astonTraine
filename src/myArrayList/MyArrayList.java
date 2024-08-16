package myArrayList;

import java.util.Iterator;

/**
 * Моя реализация динамического ArrayList.
 * Этот класс предоставляет основные методы, такие как {@link MyArrayList#add(E)},{@link MyArrayList#remove(int)}, {@link MyArrayList#size()}, {@link MyArrayList#set(int, E el)}, {@link MyArrayList#subList(int, int)}.
 *
 * @param <E> это тип данных в данной коллекции */

public class MyArrayList<E> implements MyArray<E> {
    private E[] values;
    private int size;


    /**
     * Создаетя конструктор с начальной длинной 10.
     */
    public MyArrayList() {
        values = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Метод добавления элемента в конец списка.
     *
     * @param el добавляется в конец списка
     * @return {@code true} (as specified by {@link MyArray#add})
     */
    @Override
    public boolean add(E el) {
        if(values.length == size) resize();
        values[size++] = el;
        return  true;
    }

    private void resize() {
        E[] temp = (E[]) new Object[values.length * 2];
        System.arraycopy(values,0,temp,0,values.length);
        values = temp;
    }

    /**
     * Удаляет элемент в указанной позиции в этом списке.
     * Сдвигает все последующие элементы влево (вычитает единицу из их индексов).
     * Возвращает элемент, который был удален из списка.
     *
     * @param index удаляемого элемента
     * @return элемент, который был удален
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона
     *                                   ({@code index < 0 || index >= size})
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = values[index];
        if (index < size - 1) {
            System.arraycopy(values, index + 1, values, index, size - index - 1);
        }
        values[--size] = null;

        return removedElement;
    }


    /**
     * Возвращает элемент в указанной позиции в этом списке.
     *
     * @param index позиция элемента, который нужно вернуть
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона
     *                                   ({@code index < 0 || index >= size})
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return values[index];
    }

    /**
     * Заменяет элемент по заданному индексу в этом списке.
     *
     * @param index позиция эллемента, который нужно заменить
     * @param el элемент, который нужно вставить в список
     * @return возвращает новый элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона
     *                                   ({@code index < 0 || index >= size})
     */
    @Override
    public E set(int index, E el) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return values[index] = el;
    }

    /**
     * Получить длинну списка.
     *
     * @return возвращает длину списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает новый список по заданным индексам.
     *
     * @param start начальная позиция возвращаемого списка
     * @param end конечная позиция возвращаемого списка
     * @return возвращает новый список типа {@link MyArray<E>}
     * @throws IndexOutOfBoundsException если параметры выходят за пределы диапазона
     *                                   ({@code start < 0 || end > size || start > end})
     */
    @Override
    public MyArray<E> subList(int start, int end) {
        if (start < 0 || end > size || start > end) {
            throw new IndexOutOfBoundsException("Invalid start or end index");
        }
        MyArray<E> sublist = new MyArrayList<>();
        for (int i = start; i < end ; i++) sublist.add(values[i]);
        return  sublist;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<E>(values);
    }
}
