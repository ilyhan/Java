package com.university;

import com.university.annotations.AutoInjectable;
import com.university.interfaces.SomeInterface;
import com.university.interfaces.SomeOtherInterface;

public class SomeBean {

    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}