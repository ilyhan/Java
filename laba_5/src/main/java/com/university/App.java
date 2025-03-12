package com.university;

public class App {
    public static void main(String[] args) {
        Injector injector = new Injector("otherConfig.properties");

        try {
            SomeBean sb = injector.inject(new SomeBean());
            sb.foo();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
