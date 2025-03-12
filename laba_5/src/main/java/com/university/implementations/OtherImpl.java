package com.university.implementations;

import com.university.interfaces.SomeInterface;

/**
 * Класс OtherImpl реализует интерфейс SomeInterface
 *
 * @see SomeInterface
 */
public class OtherImpl implements SomeInterface {
    /**
     * Метод doSomething выводит в консоль символ "B"
     */
    @Override
    public void doSomething(){ 
        System.out.println("B");
    }
}