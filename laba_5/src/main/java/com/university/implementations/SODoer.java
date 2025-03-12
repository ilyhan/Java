package com.university.implementations;

import com.university.interfaces.SomeOtherInterface;

class SODoer implements SomeOtherInterface {
    
    @Override
    public void doSomeOther(){ 
        System.out.println("C");
    }
}