package org.example;

import java.util.Comparator;

/**
 * Hеализация двусвязного списка
 * @param <E> тип объектов в списке
 */
public class NewLinkedList<E> implements NewList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Конструктор по умолчанию, создает пустой двусвязный список
     */
    NewLinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Внутренний класс узла, представляющий объект списка
     *
     * @param <E> тип объекта в узле
     */
    private static class Node<E>{
        Node<E> next;
        Node<E> prev;
        E element;

        Node(Node<E> prev, Node<E> next, E element){
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }
    /**
     * Добавляет объект в указанную позицию в списке
     *
     * @param index индекс, по которому должен быть вставлен объект
     * @param obj   объект, который должен быть вставлен
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void add(int index, E obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(obj);
        } else {
            Node<E> current = getNode(index);
            Node<E> newNode = new Node<>(current.prev, current, obj);
            if (current.prev == null) {
                first = newNode;
            } else {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            size++;
        }
    }

    /**
     * Добавляет объект в конец списка
     *
     * @param obj добавляемый объект
     */
    public void add(E obj) {
        Node<E> newNode = new Node<>(last, null, obj);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }
    /**
     * Возвращает узел по указанному индексу
     *
     * @param index индекс возвращаемого узла списка
     * @return узел по указанному индексу
     */
    private Node<E> getNode(int index) {
        Node<E> current;
        if (index < (size / 2)) {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /**
     * Возвращает объект по указанному индексу
     *
     * @param index индекс возвращаемого объекта списка
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).element;
    }

    /**
     * Удаляет указанный объект из списка
     *
     * @param obj удаляемый объект списка
     * @return возвращает удаленный объект, если он был найден и удален, иначе null
     */
    public E remove(E obj) {
        Node<E> current = first;
        while (current != null) {
            if ((current.element == null && obj == null) || (current.element != null && current.element.equals(obj))) {
                if (current.prev == null) { // current is the first node
                    first = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next == null) { // current is the last node
                    last = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                size--;
                return current.element;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Удаляет все элементы из списка.
     */
    public void clear() {
        Node<E> current = first;
        while (current != null) {
            Node<E> next = current.next;
            current.element = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * Сортирует элементы списка методом вставки
     */
    public void sort() {
        if (size > 1) {
            for (Node<E> current = first.next; current != null; current = current.next) {
                E key = current.element;
                Node<E> previous = current.prev;
                while (previous != null && comparator().compare(previous.element, key) > 0) {
                    previous.next.element = previous.element;
                    previous = previous.prev;
                }
                if (previous == null) {
                    first.element = key;
                } else {
                    previous.next.element = key;
                }
            }
        }
    }
    /**
     * Возвращает компаратор для сравнения элементов
     *
     * @return компаратор для сравнения элементов
     */
    private Comparator<E> comparator() {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return ((Comparable<E>) o1).compareTo(o2);
        };
    }


}
