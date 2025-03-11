package com.university;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.university.models.Department;

public class DepartmentTest {
    @Test
    public void testToString() {
        Department department = new Department("IT");
        assertEquals("Department{id=1, name='IT'}", department.toString());
    }

    @Test
    public void testDepartmentId() {
        Department department1 = new Department("IT");
        Department department2 = new Department("Car");
        assertEquals("Department{id=2, name='IT'}", department1.toString());
        assertEquals("Department{id=3, name='Car'}", department2.toString());
    }
}
