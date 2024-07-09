package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация списка на основе массива
 * @param <E> тип объектов в списке
 */
public class NewArrayList<E> implements NewList<E>{

    private final int CONST_SIZE = 10;
    private int size;
    private int capacity;
    private Object[] arr;

    public int size(){
        return size;
    }

    /**
     * Возвращает актуальный размер листа
     * @return воз
     */
    public int size(){
        return size;
    }

    /**
     * Конструктор по умолчания, создает пустой список с заданным размером по умолчанию
     */
    public NewArrayList(){
        arr = new Object[CONST_SIZE];
        size = CONST_SIZE;
    }

    /**
     * Конструктор создающий список с заданным размером
     * @param size размер списка
     */
    public NewArrayList(int size) {
        arr = new Object[size];
        this.size = size;
    }

    /**
     *
     * @param index индекс по которому должен быть вставлен объект
     * @param obj объект, который должен быть вставлен
     * @throws IndexOutOfBoundsException при выходе индекса за границы 0 < index < size
     */
    public void add(int index, E obj) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        compArr();
        if (capacity - index >= 0) System.arraycopy(arr, index, arr, index + 1, capacity - index);
        arr[index] = obj;
        capacity++;

    }

    /**
     * Добавляет объект в список
     * @param obj добавляемый объект
     */
    public void add(E obj) {
        compArr();
        for (int i = 0; i < size; i++){
            if (arr[i] == null) {
                arr[i] = obj;
                break;
            }
        }
        capacity++;
    }

    /**
     * Возвращает объект по указанному индексу
     * @param index индекс возвращаемоо объекта списка
     * @return
     */
    public E get(int index) {
        return (E) arr[index];
    }

    /**
     * удаляет объект из списка
     * @param obj удаляемый объект списка
     * @return возвращает удаленный объект
     */
    public E remove(E obj) {
        for (int i = 0; i < size; i++){
            if(arr[i] != null  && arr[i].equals(obj)) {
                System.arraycopy(arr, i + 1, arr, i, capacity - i - 1);
                capacity--;
            }
        }
        return null;
    }

    /**
     * Удаляет все объекты списка, заменив их на null
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            arr[i] = null;
        capacity = 0;
    }

    /**
     * Сортирует список, используя компаратор для объектов списка
     */
    public void sort() {
        Arrays.sort((E[]) arr, 0, capacity, comparator());
    }

    /**
     * Увеличивает емкость массива при необходимости в полтора раза
     */
    void compArr(){
        if (capacity >= size){
            size = (size * 3) / 2 + 1;
            Object[] copyArr = new Object[size];
            System.arraycopy(arr, 0, copyArr, 0, arr.length);
            arr = copyArr;
        }

    }

    /**
     * Возвращает компаратор для сравнения объектов
     * @return компаратор для сравнения объектов
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
