package com.university;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.university.enums.Gender;
import com.university.models.Department;
import com.university.models.Person;

public class PersonTest {
    @Test
    public void testToString() throws ParseException {
        Department department = new Department("Frontend");
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse("17.12.2003");

        Person person = new Person(1, "Ilia", Gender.MALE, department, 100000, birthDate);

        String expected = "Person{id = 1, name = 'Ilia', gender = MALE, department = Department{id=4, name='Frontend'}, salary = 100000.0, birthDate = 17.12.2003}";
        assertEquals(expected, person.toString());
    }
}
