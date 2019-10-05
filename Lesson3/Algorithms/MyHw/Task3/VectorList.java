package com.company.Task3;

import java.util.Iterator;

public class VectorList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int counter = 0;

    public VectorList() {
        first = new Node<>();
        last = first;
    }

    public int size() {
        return counter;
    }

    public void insertFirst(E element) {
        if (counter == 0) {
            first.set(element);
        } else {
            first = first.addFirst(element);
        }
        counter++;
    }

    public void insertLast(E element) {
        if (counter == 0) {
            last.set(element);
        } else {
            last = last.addLast(element);
        }
        counter++;
    }

    @Override
    public Iterator<E> iterator() {
        return new VectorIterator(first);
    }

    private class Node<E> {
        private E element;
        private Node<E> prev = null;
        private Node<E> next = null;

        Node() {
        }

        Node(E element) {
            set(element);
        }

        void set(E element) {
            this.element = element;
        }

        Node<E> addFirst(E element) {
            Node<E> newNode = new Node<>(element);
            newNode.next = this;
            prev = newNode;
            return newNode;
        }

        Node<E> addLast(E element) {
            next = new Node<>(element);
            next.prev = this;
            return next;
        }

        E get() {
            return element;
        }

        boolean isNext() {
            return next != null;
        }
    }

    // Итератор, светить наружу его тоже не хочется, он слишком специфичный.
    private class VectorIterator implements Iterator<E> {
        private Node<E> current;
        private boolean isFirst = true;     // первый узел надо обработать отдельно

        VectorIterator(Node<E> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            if (counter == 1 && isFirst) {
                return true;   // отдельно обработать один элемент (потому как у него нет next)
            }
            return current.isNext();
        }

        @Override
        public E next() {
            if (isFirst) {
                isFirst = false;
            } else {
                current = current.next;
            }
            return current.get();
        }
    }
}
