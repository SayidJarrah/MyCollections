package ua.com.dkorniichuk.Collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyHashSetTest {
    Set<Integer> set;


    @Before
    public void setUp() {
        set = new MyHashSet<>();
        set.add(111);
        set.add(222);
    }

    @Test
    public void testAdd() {
        set.add(333);
        set.add(222);
        set.add(111);
        assertTrue(set.size() == 3);

    }

    @Test
    public void testRemove() {
        set.remove(222);
        assertTrue(set.size() == 1);
    }

    @Test
    public void testValues() {
        MyArrayList<Integer> list = set.values();
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.contains(111) && list.contains(222));
            assertTrue(list.size() == 2);
        }

    }

    @Test
    public void testContains() {
        assertTrue(set.contains(111));
        assertFalse(set.contains(555));

    }

    @Test
    public void testSize() {
        assertTrue(set.size() == 2);

    }

    @Test
    public void testClear() {
        set.clear();
        assertTrue(set.size() == 0);

    }
}