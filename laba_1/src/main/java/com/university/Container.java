package com.university;

// контейнер для хранения целочисленных данных
public class Container {
    private int[] arr;
    private int size;

    // начальная размер контейнера 
    protected static final int CAPACITY = 10;

    // конструктор который создает новый контейнер с начальным размером по умолчанию
    public Container() {
        arr = new int[CAPACITY];
        size = 0;
    }
    
    // метод проверки индеса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of array");
        }
    }

    // метод получения значения элемента по индексу
    public int get(int index) {
        checkIndex(index);
        return arr[index];
    }

    // метод добавления нового элемента
    public void add(int element) {
        if (size == arr.length) {
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        arr[size++] = element;
    }

    // метод удаления элемента
    public int remove(int index) {
        checkIndex(index);
        int removedElement = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return removedElement;
    }

    // метод очистки контейнера
    public void clear() {
        arr = new int[CAPACITY];
        size = 0;
    }

    // метод проверки вхождения элемента в контейнер
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }
    
    // метод получения рамера контейнера
    public int size() {
        return size;
    }
}