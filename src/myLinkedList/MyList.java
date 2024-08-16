package myLinkedList;

public interface MyList <E>{
    boolean add(E e);
    E remove(int index);
    int size();
    E getElementByIndex(int index);

}
