package com.university;

import com.university.annotations.AutoInjectable;
import com.university.interfaces.SomeInterface;
import com.university.interfaces.SomeOtherInterface;

/**
 * Класс для внедрения зависимостей
 */
public class SomeBean {

    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Метод, который использует внедренные зависимости.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}