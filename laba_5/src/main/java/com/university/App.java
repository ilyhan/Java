package com.university;

/**
 * Главный класс 
 */
public class App {
    /**
     * Точка входа в приложение
     *
     * @param args аргументы командной строки (не используются)
     */
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
