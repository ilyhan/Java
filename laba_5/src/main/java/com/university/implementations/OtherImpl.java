package com.university.implementations;

import com.university.interfaces.SomeInterface;

class OtherImpl implements SomeInterface {
    
    @Override
    public void doSomething(){ 
        System.out.println("B");
    }
}