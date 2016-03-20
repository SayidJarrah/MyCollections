package ua.com.dkorniichuk.mycollections.Map;

import ua.com.dkorniichuk.mycollections.Collection.MyArrayList;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    MyArrayList<K> keys();

    String toString();

    int size();

    void putIfAbsent(K key, V value);

    boolean containsKey(K key);

    boolean containsValue(V value);

    void putAll(MyHashMap hashMap);

    void clear();
}
