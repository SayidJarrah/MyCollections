package ua.com.dkorniichuk.mycollections.Collection;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public interface Set<E> {

    void add(E value);

    void remove(E value);

    MyArrayList<E> values();

    boolean contains(E value);

    int size();

    void clear();

}
