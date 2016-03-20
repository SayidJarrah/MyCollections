package ua.com.dkorniichuk.mycollections.Collection;

import java.util.Arrays;

/**
 * Created by dkorniichuk on 24.12.2015.
 */
public class MyArrayList<E> implements List<E> {


    private static final int DEFAULT_SIZE = 5;
    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(E value) {
        add(size, value);
    }

    void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E value) {
        validateIndex(index);
        if (size == elements.length) {
            int length = elements.length * 3 / 2 + 1;
            Object[] expandedArray = new Object[length];
            System.arraycopy(elements, 0, expandedArray, 0, length);
            elements = (E[]) expandedArray;
        }
        System.arraycopy(elements, index, elements, index + 1, elements.length - index - 1);
        elements[index] = value;
        size++;

    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public void set(int index, E value) {
        validateIndex(index);
        elements[index] = value;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        validateIndex(index);
        Object removedElement = elements[index];
        int leftShift = size - index - 1;
        System.arraycopy(elements, index + 1, elements, index, leftShift);
        size--;
        elements[index + 1] = null;
        return (E) removedElement;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i > 0; i--) {
            if (value.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}

