package com.university.models;

import java.util.Date;

import com.university.enums.*;

public class Person {
    private int id; // ID
    private String name; // Имя
    private Gender gender; // Пол
    private Department department; // Подразделение(Сущность подразделение)
    private double salary; // Зарплата
    private Date birthDate; // Дата рождения

    public Person(int _id, String _name, Gender _gender, Department _department, double _salary, Date _birthDate) {
        this.id = _id;
        this.name = _name;
        this.gender = _gender;
        this.department = _department;
        this.salary = _salary;
        this.birthDate = _birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", gender = " + gender +
                ", department = " + department.toString() +
                ", salary = " + salary +
                ", birthDate = " + birthDate +
                '}';
    }
}
