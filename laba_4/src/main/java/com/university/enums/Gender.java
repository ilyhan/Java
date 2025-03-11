package com.university.enums;

/**
 * Перечисление для пола
 */
public enum Gender {
    /**
     * Мужской пол
     */
    MALE, 
    
    /**
     * Женский пол
     */
    FEMALE;

    /**
     * Возвращает объект Gender на основе строкового значения
     *
     * @param gender строка представляющая пол ("male" или "female")
     * @return объект Gender (по умолчанию MALE)
     */
    public static Gender getGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            default:
                return MALE;
        }
    }
}