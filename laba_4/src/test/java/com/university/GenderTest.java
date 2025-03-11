package com.university;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.university.enums.Gender;

public class GenderTest {
    @Test
    public void testGetGenderMale() {
        assertEquals(Gender.MALE, Gender.getGender("male"));
    }

    @Test
    public void testGetGenderFemale() {
        assertEquals(Gender.FEMALE, Gender.getGender("female"));
    }

    @Test
    public void testGetGenderDefault() {
        assertEquals(Gender.MALE, Gender.getGender("other"));
    }
}
