package pl.kszafran.sda.algo.exercises;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Zaimplementuj poniższe metody operujące na liście wiązanej jednokierunkowej.
 */
public class Exercises4 {

    /**
     * Tworzy nową listę zawierającą podane elementy.
     */
    public <T> SdaList<T> createList(T... elements) {
        return new SdaLinkedList<>(elements);
    }

    public interface SdaList<T> extends Iterable<T> {

        /**
         * Zwraca true jeśli lista jest pusta.
         */
        boolean isEmpty();

        /**
         * Zwraca rozmiar listy (ilość elementów).
         */
        int size();

        /**
         * Zwraca pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getFirst();

        /**
         * Zwraca ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        T getLast();

        /**
         * Pobiera element listy pod podanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        T get(int index);

        /**
         * Usuwa wszystkie elementy z listy.
         */
        void clear();

        /**
         * Dodaje nowy element na początku listy.
         */
        void addFirst(T element);

        /**
         * Dodaje nowy element na końcu listy.
         */
        void addLast(T element);

        /**
         * Usuwa pierwszy element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeFirst();

        /**
         * Usuwa ostatni element listy.
         *
         * @throws NoSuchElementException jeśli lista jest pusta
         */
        void removeLast();

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        /**
         * Zwraca iterator po elementach listy.
         *
         * @see java.lang.Iterable
         */
        @Override
        Iterator<T> iterator();

        /**
         * Zamienia element pod podanym indeksem.
         */
        void setAt(int index, T element);

        /**
         * Dodaje nowy element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void addAt(int index, T element);

        /**
         * Usuwa element pod wskazanym indeksem.
         *
         * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
         */
        void removeAt(int index);
    }

    private static class SdaLinkedList<T> implements SdaList<T> {

        private Node<T> head;

        public SdaLinkedList(T[] elements) {
            T[] arrayElementLink;
            for (int i = elements.length - 1; i >= 0; i--) {
                addFirst(elements[i]);
            }
        }

        @Override
        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public int size() {
            if (head == null) return 0;
            return sizeRec(head);
        }

        public int sizeRec(Node<T> pointer) {
            if (pointer.next == null) {
                return 1;
            }
            return 1 + sizeRec(pointer.next);
        }

        @Override
        public T getFirst() {
            if (isEmpty())
                throw new NoSuchElementException();
            return head.element;
        }

        @Override
        public T getLast() {
            if (isEmpty())
                throw new NoSuchElementException();
            Node<T> pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            return pointer.element;
        }

        @Override
        public T get(int index) {
            if (index < 0)
                throw new IndexOutOfBoundsException();
            if (isEmpty())
                throw new IndexOutOfBoundsException();
            Node<T> pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return pointer.element;
        }

        @Override
        public void clear() {
            head = null;
        }

        @Override
        public void addFirst(T element) {
            head = new Node<>(element, head);
        }

        @Override
        public void addLast(T element) {
            if (isEmpty()) addFirst(element);
            else {
                Node<T> pointer = head;
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = new Node<>(element, null);
            }
        }

        @Override
        public void removeFirst() {
            if (isEmpty()) throw new NoSuchElementException();
            head = head.next;
        }

        @Override
        public void removeLast() {
            if (isEmpty()) throw new NoSuchElementException();
            if (head.next == null) {
                head = null;
                return;
            }
            Node<T> pointPrev = head;
            Node<T> pointNext = head.next;
            while (pointNext.next != null) {
                pointPrev = pointNext;
                pointNext = pointNext.next;
            }
            pointPrev.next = null;
        }

        ////////////////////////////////////////////
        //                                        //
        // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
        //                                        //
        ////////////////////////////////////////////

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Node<T> node = head;
                private Node<T> prev = node;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public T next() {
                    if (node == null) throw new NoSuchElementException();
                    T element = node.element;
                    prev = node;
                    node = node.next;
                    return element;
                }

                @Override
                public void remove() {
                    if (!hasNext()) throw new NoSuchElementException();
                    prev.next = null;
                }
            };
        }

        @Override
        public void setAt(int index, T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void addAt(int index, T element) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public void removeAt(int index) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        private static class Node<T> {
            private T element;
            private Node<T> next;

            private Node(T element, Node<T> next) {
                this.element = element;
                this.next = next;
            }
        }
    }
}
