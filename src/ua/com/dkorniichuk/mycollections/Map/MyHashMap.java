package ua.com.dkorniichuk.mycollections.Map;

import ua.com.dkorniichuk.mycollections.Collection.MyArrayList;

import java.util.ArrayList;


public class MyHashMap<K, V> implements Map<K, V> {
    private final static int BUCKETS_AMOUNT = 16;
    private MyArrayList[] array;
    private int size;

    public MyHashMap() {
        array = new MyArrayList[BUCKETS_AMOUNT];
        for (int i = 0; i < BUCKETS_AMOUNT; i++) {
            array[i] = new MyArrayList();
        }
    }

    @Override
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        int bucketNumber = Math.abs(entry.getKey().hashCode() % BUCKETS_AMOUNT);
        for (int i = 0; i < array[bucketNumber].size(); i++) {
            Entry<K, V> element = (Entry<K, V>) array[bucketNumber].get(i);
            if (element.getKey().equals(key)) {
                array[bucketNumber].remove(i);
                size--;
            }
        }
        array[bucketNumber].add(entry);
        size++;
    }

    @Override
    public V get(K key) {
        int bucketNumber = Math.abs(key.hashCode() % BUCKETS_AMOUNT);
        MyArrayList searchedBucket = array[bucketNumber];
        for (int i = 0; i < searchedBucket.size(); i++) {
            Entry<K, V> entry = (Entry<K, V>) searchedBucket.get(i);
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int bucketNumber = Math.abs(key.hashCode() % BUCKETS_AMOUNT);
        MyArrayList searchedBucket = array[bucketNumber];
        for (int i = 0; i < searchedBucket.size(); i++) {
            Entry entry = (Entry) searchedBucket.get(i);
            if (entry.getKey().equals(key)) {
                Entry<K, V> removedElement = entry;
                searchedBucket.remove(i);
                size--;
                return removedElement.getValue();
            }

        }
        return null;
    }

    @Override
    public MyArrayList<K> keys() {
        MyArrayList<K> keySet = new MyArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                Entry<K, V> entry = (Entry<K, V>) array[i].get(j);
                keySet.add(entry.getKey());
            }
        }
        return keySet;
    }

    public ArrayList<V> values() {
        ArrayList valuesSet = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                Entry<K, V> entry = (Entry<K, V>) array[i].get(j);
                valuesSet.add(entry.getValue());
            }
        }
        return valuesSet;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void putIfAbsent(K key, V value) {
        if (!keys().contains(key)) {
            put(key, value);
        }
    }

    @Override
    public boolean containsKey(K key) {
        return keys().contains(key) ? true : false;
    }

    @Override
    public boolean containsValue(V value) {
        return values().contains(value) ? true : false;
    }


    @Override
    public void putAll(MyHashMap hashMap) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < hashMap.getArray().length; i++) {
            for (int j = 0; j < hashMap.getArray()[i].size(); j++) {
                list.add(hashMap.getArray()[i].get(j));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            putIfAbsent(((Entry<K, V>) list.get(i)).getKey(), ((Entry<K, V>) list.get(i)).getValue());
        }

    }

    @Override
    public void clear() {
        for (int i = 0; i < BUCKETS_AMOUNT; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                array[i].clear();
            }
        }
        size = 0;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                Entry<K, V> entry = (Entry<K, V>) array[i].get(j);
                stringBuilder.append(entry).append("\n");
            }

        }
        return String.valueOf(stringBuilder);
    }

    public MyArrayList[] getArray() {
        return array;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }


        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }
}
