package com.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit тесты
 */
public class AppTest {
    @Test
    public void testNullParamConstructor() {
        assertThrows(Exception.class, () -> {
            new Injector(null);
        });
    }

    @Test
    public void testNullObject() {
        Injector injector = new Injector("config.properties");

        assertThrows(Exception.class, () -> {
            injector.inject(null);
        });
    }

    @Test
    public void testFirstFileProperties() {
        Injector injector = new Injector("config.properties");
        injector.inject(new SomeBean()).foo();

        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    @Test
    public void testSecondFileProperties() {
        Injector injector = new Injector("otherConfig.properties");
        injector.inject(new SomeBean()).foo();

        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }
}