package com.university.models;

/**
 * Класс, представляющий подразделение
 */
public class Department {
    private static int lastId = 1; // Счетчик для генерации уникального ID

    private int id; // ID
    private String name; // Название 

    /**
     * Конструктор для создания объекта подразделения
     *
     * @param _name название подразделения
     */
    public Department(String _name) {
        this.id = generateId();
        this.name = _name;
    }

    /**
     * Генерирует уникальный идентификатор для подразделения
     *
     * @return уникальный идентификатор
     */
    private static int generateId() {
        return lastId++;
    }

    /**
     * Возвращает строковое представление объекта подразделения
     *
     * @return строка, содержащая ID и название подразделения
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}