package com.university.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.university.enums.*;

/**
 * Класс, представляющий человека.
 */
public class Person {
    private int id; // ID
    private String name; // Имя
    private Gender gender; // Пол
    private Department department; // Подразделение(Сущность подразделение)
    private double salary; // Зарплата
    private Date birthDate; // Дата рождения

    /**
     * Конструктор для создания объекта человека.
     *
     * @param _id ID 
     * @param _name Имя
     * @param _gender Пол
     * @param _department Подразделение(Сущность подразделение)
     * @param _salary Зарплата
     * @param _birthDate Дата рождения
     */
    public Person(int _id, String _name, Gender _gender, Department _department, double _salary, Date _birthDate) {
        this.id = _id;
        this.name = _name;
        this.gender = _gender;
        this.department = _department;
        this.salary = _salary;
        this.birthDate = _birthDate;
    }

    /**
     * Возвращает строковое представление объекта человека
     *
     * @return строка, содержащая ID человека, имя, пол, подразделение, зарплату и дату рождения
     */
    @Override
    public String toString() {
        String formattedDate = birthDate != null
                ? new SimpleDateFormat("dd.MM.yyyy").format(birthDate)
                : "Не указана";

        return "Person{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", gender = " + gender +
                ", department = " + department.toString() +
                ", salary = " + salary +
                ", birthDate = " + formattedDate +
                '}';
    }
}
