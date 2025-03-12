package com.university.implementations;

import com.university.interfaces.SomeOtherInterface;

/**
 * Класс SODoer реализует интерфейс SomeOtherInterface
 *
 * @see SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface {
    /**
     * Метод doSomeOther выводит в консоль символ "С"
     */
    @Override
    public void doSomeOther(){ 
        System.out.println("C");
    }
}