package com.university.models;

public class Department {
    private static int lastId = 1;

    private int id; // ID
    private String name; // Название

    public Department(String _name) {
        this.id = generateId();
        this.name = _name;
    }

    private static int generateId() {
        return lastId++;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
