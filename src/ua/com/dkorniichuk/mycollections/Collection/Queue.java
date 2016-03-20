package ua.com.dkorniichuk.mycollections.Collection;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public interface Queue<E> {
    void add(E value);

    E poll();

    int size();

    E peek();
}
