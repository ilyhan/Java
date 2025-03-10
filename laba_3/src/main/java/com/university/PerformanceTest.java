package com.university;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, содержащий тесты производительности операций add, delete и get 
 * для ArrayList и LinkedList
 */
public class PerformanceTest {
    /**
     * Главный метод, проводящий тестирование производительности операций 
     * add, delete и get для ArrayList и LinkedList.
     *
     * @param args аргументы командной строки 
     * @throws NullPointerException список не инициализирован 
     * @throws IndexOutOfBoundsException индекс выходит за пределы списка
     */
    public static void main(String[] args) {
        int iterations = 2000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // тестируем метод add
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(i);
        }
        long timeArrayListAdd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(i);
        }
        long timeLinkedListAdd = System.nanoTime() - start;

        // тестируем метод delete
        start = System.nanoTime();
        for (int i = iterations - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        long timeArrayListDelete = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = iterations - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        long timeLinkedListDelete = System.nanoTime() - start;

        for (int i = 0; i < iterations; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // тестируем метод get
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.get(i);
        }
        long timeArrayListGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.get(i);
        }
        long timeLinkedListGet = System.nanoTime() - start;

        // тестируем метод contains
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.contains(i);
        }
        long timeArrayListContains = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.contains(i);
        }
        long timeLinkedListContains = System.nanoTime() - start;

        String TABLE_ROW_FORMAT = "%-10s  %-20d  %-20d  %-20d  %-20d%n";
        System.out.printf("%-10s  %-12s  %-12s  %-12s  %-12s%n", "Операция", "Количество повторений", "Время ArrayList (нс)", "Время LinkedList (нс)", "Разница (нс)");
        System.out.printf(TABLE_ROW_FORMAT, "add", iterations, timeArrayListAdd, timeLinkedListAdd, timeLinkedListAdd - timeArrayListAdd);
        System.out.printf(TABLE_ROW_FORMAT, "delete", iterations, timeArrayListDelete, timeLinkedListDelete, timeLinkedListDelete - timeArrayListDelete);
        System.out.printf(TABLE_ROW_FORMAT, "get", iterations, timeArrayListGet, timeLinkedListGet, timeLinkedListGet - timeArrayListGet);
        System.out.printf(TABLE_ROW_FORMAT, "contains", iterations, timeArrayListContains, timeLinkedListContains, timeLinkedListContains - timeArrayListContains);
    }
}