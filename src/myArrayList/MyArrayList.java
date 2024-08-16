package myArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyArrayList<E> implements MyArray<E> {
    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E el) {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp,0,values,0,temp.length);
            values[values.length-1] = el;
            return  true;
    }
    @Override
    public void remove(int index) {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp,0,values, 0, index);
            int elemAfterIndex = temp.length-index-1;
            System.arraycopy(temp,index+1,values,index, elemAfterIndex);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public E set(int index, E el) {
        return values[index] = el;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public MyArray<E> subList(int start, int end) {
        if (start < 0 || end > values.length || start > end) {
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
