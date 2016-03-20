package ua.com.dkorniichuk.mycollections.Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements Queue<E>, Iterable<E> {
    private Node<E> first;
    private int size;

    public MyQueue() {
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node(value);
        Node<E> currentNode = first;
        if (size == 0) {
            first = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public E poll() {
        return size != 0 ? first.value : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            Node<E> result = first;
            first = first.next;
            size--;
            return result.value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }


    private static class Node<E> {
        E value;
        Node<E> next;


        public Node(E value) {
            this.value = value;
        }
    }

    public class MyIterator<E> implements Iterator<E> {
        private MyQueue<E> queue;
        int index;

        public MyIterator() {
            queue = (MyQueue<E>) MyQueue.this;
        }


        @Override
        public boolean hasNext() {
            return queue.size() != index;
        }

        @Override
        public E next() {
            if (hasNext()) {
                Node<E> result = queue.first;
                queue.first = queue.first.next;
                index++;
                return result.value;
            } else {
                throw new NoSuchElementException("No element");
            }
        }

        @Override
        public void remove() {
          /*  if (hasNext()) {
                Node<E> currentNode = (Node<E>) first;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }


                currentNode.value = next();
                //currentNode.next;
                queue.first = queue.first.next;
                index++;
            } else {
                throw new NoSuchElementException("No element");
            }



            }*/

        }
    }
}
