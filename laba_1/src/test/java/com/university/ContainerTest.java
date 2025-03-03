package com.university;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContainerTest {
    @Test
    public void testAddAndGet() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(3, container.get(2));
    }

    @Test
    public void testAddAndOutOfRange() {
        Container container = new Container();
        for(int i = 0; i < 15; i++){
            container.add(i);
        }

        assertEquals(15, container.size());
    }

    @Test
    public void testAddAndSize() {
        Container container = new Container();
        assertEquals(0, container.size());

        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(3, container.size());
    }

    @Test
    public void testRemove() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(1, container.remove(0));
        assertEquals(2, container.size());
    }

    @Test
    public void testClear() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        container.add(3);
        assertEquals(3, container.size());

        container.clear();
        assertEquals(0, container.size());
    }

    @Test
    public void testContains() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(true, container.contains(2));
        assertEquals(false, container.contains(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfArray() {
        Container container = new Container();
        container.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfArray() {
        Container container = new Container();
        container.get(0);
    }
}