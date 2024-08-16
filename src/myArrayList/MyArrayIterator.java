package myArrayList;

import java.util.Iterator;

public class MyArrayIterator<E> implements Iterator<E> {
    private E[] values;
    private int index;

    public MyArrayIterator(E[] values) {
        this.values = values;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
