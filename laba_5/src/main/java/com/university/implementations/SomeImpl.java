package com.university.implementations;

import com.university.interfaces.SomeInterface;
/**
 * Класс SomeImpl реализует интерфейс SomeInterface
 *
 * @see SomeInterface
 */
public class SomeImpl implements SomeInterface {
    /**
     * Метод doSomething выводит в консоль символ "А"
     */
    @Override
    public void doSomething(){ 
        System.out.println("A");
    }
}