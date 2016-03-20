package ua.com.dkorniichuk.mycollections.Collection;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public interface List<E> {
    void add(E value);

    void add(int index, E value);

    E get(int index);

    void set(int index, E value);

    E remove(int index);

    void clear();

    int size();

    int indexOf(E value);

    int lastIndexOf(E value);

    boolean contains(E value);
}
