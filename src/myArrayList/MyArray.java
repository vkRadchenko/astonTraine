package myArrayList;

public interface MyArray<E> extends Iterable<E> {
    boolean add(E el);
    void remove(int index);
    E get(int index);
    E set(int index, E el);
    int size();
    MyArray<E> subList(int start, int end);
}
