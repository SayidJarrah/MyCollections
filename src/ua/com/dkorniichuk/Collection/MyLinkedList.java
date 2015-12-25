package ua.com.dkorniichuk.Collection;


public class MyLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;


    public MyLinkedList() {
    }


    @Override
    public void add(E value) {
        Node<E> node = new Node<>(value);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        last.next = first;
        first.prev = last;
        size++;
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, E value) {
        validateIndex(index);
        if (index == size) {
            add(value);
        } else {
            Node previousNode = nodeLocation(index);
            Node<E> newNode = new Node<>(value, previousNode, previousNode.prev);
            size++;
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
            if (index == 0) {
                first = newNode;
            }
            if (index == (size - 1)) {
                last = newNode;
            }

        }

    }

    public Node<E> nodeLocation(int index) {
        Node<E> node;
        if (index <= (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return nodeLocation(index).value;
    }

    @Override
    public void set(int index, E value) {
        validateIndex(index);
        nodeLocation(index).value = value;

    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        Node<E> removableElement = nodeLocation(index);
        removableElement.prev.next = removableElement.next;
        removableElement.next.prev = removableElement.prev;
        E returnedValue = removableElement.value;
        if (last == removableElement) {
            last = removableElement.prev;
        }
        if (first == removableElement) {
            first = removableElement.next;
        }
        removableElement.next = null;
        removableElement.prev = null;
        removableElement.value = null;
        size--;
        return returnedValue;
    }

    @Override
    public void clear() {
        for (Node<E> node = first; node != null; ) {
            Node next = node.next;
            node.next = null;
            node.prev = null;
            node.value = null;
            node = next;
        }
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        Node<E> node = first;
        if (size == 1 && value.equals(node.value)) {
            return 1;
        } else {
            for (; node != last; node = node.next) {
                if (value.equals(node.value)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = size;
        Node<E> node = last;
        if (size == 1 && value.equals(node.value)) {
            return 1;
        } else {
            for (; node != first; node = node.prev) {
                index--;
                if (value.equals(node.value)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }


    private static class Node<E> {

        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(E value) {
            this.value = value;
        }

    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
