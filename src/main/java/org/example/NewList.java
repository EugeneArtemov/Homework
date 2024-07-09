package org.example;

public interface NewList<E>{

    int size();

    /**
     * Возвращает актуальный размер листа
     * @return возвращает целочисленное значние количества элементов
     */
    int size();

    /**
     * Дабавляет элемент в список по указанному индексу
     * @param index индекс по которому должен быть вставлен объект
     * @param obj объект, который должен быть вставлен
     * @throws IndexOutOfBoundsException при выходе индекса за границу
     */
    void add(int index, E obj);

    /**
     * Добавляет элемент в список
     * @param obj добавляемый объект
     * @throws IndexOutOfBoundsException при выходе индекса за границу
     */
    void add(E obj);

    /**
     * Возвращает объект по индексу
     * @param index индекс возвращаемоо объекта списка
     * @return возвращаемый объект списка
     * @throws IndexOutOfBoundsException при выходе индекса за границу
     */
    E get(int index);

    /**
     *
     * @param obj удаляемый объект списка
     * @return возвращает удаленный объект списка
     *
     */
    E remove(E obj);

    /**
     * Удаляет все объекты списка
     */
    void clear();

    /**
     * Сортирует список
     */
    void sort();
}
