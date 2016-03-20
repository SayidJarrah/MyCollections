package ua.com.dkorniichuk.mycollections.Collection;

import ua.com.dkorniichuk.mycollections.Map.MyHashMap;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public class MyHashSet<E> implements Set<E> {

    private MyHashMap map;
    private static final Object DUMMY = new Object();

    public MyHashSet() {
        map = new MyHashMap();
    }

    @Override
    public void add(E value) {
        map.put(value, DUMMY);
    }

    @Override
    public void remove(E value) {
        map.remove(value);

    }

    @Override
    public MyArrayList values() {
        return map.keys();
    }

    @Override
    public boolean contains(E value) {
        return values().contains(value);

    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }
}
