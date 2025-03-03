package com.university;

/**
 * Контейнер для хранения целочисленных данных
 * Поддерживает добавление, удаление, поиск и проверку наличия элементов
 */
public class Container {
    private int[] arr;
    private int size;

    /** Начальная размерность контейнера по умолчанию */
    protected static final int CAPACITY = 10;

    /**
     * Создает новый контейнер с начальной размерностью по умолчанию
     */
    public Container() {
        arr = new int[CAPACITY];
        size = 0;
    }

    /**
     * Проверяет, что индекс находится в допустимых пределах
     *
     * @param index индекс для проверки
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of array");
        }
    }

    /**
     * Возвращает элемент по индексу
     *
     * @param index индекс элемента
     * @return элемент по индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public int get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Добавляет новый элемент в контейнер
     * Если массив заполнен, его размер увеличивается в два раза
     *
     * @param element элемент для добавления
     */
    public void add(int element) {
        if (size == arr.length) {
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        arr[size++] = element;
    }

    /**
     * Удаляет элемент по указанному индексу
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public int remove(int index) {
        checkIndex(index);
        int removedElement = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return removedElement;
    }

    /**
     * Очищант контейнер, удаляя все элементы
     * После очистки контейнер возвращается в начальное состояние
     */
    public void clear() {
        arr = new int[CAPACITY];
        size = 0;
    }

    /**
     * Проверяет, содержится ли указанный элемент в контейнере
     *
     * @param element элемент для поиска
     * @return true, если элемент найден, иначе false
     */
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает текущий размер контейнера
     *
     * @return количество элементов в контейнере
     */
    public int size() {
        return size;
    }
}