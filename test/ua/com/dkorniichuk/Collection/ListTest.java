package ua.com.dkorniichuk.Collection;


import org.junit.Before;
import org.junit.Test;
import ua.com.dkorniichuk.Model.Person;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ListTest {
    List<Person> list;

    @Before
    public abstract void setUp();

    @Test
    public void testAdd() throws Exception {
        list.add(new Person("Hugo", "Reyes", 27));
        list.add(new Person("Linus", "Ben", 33));

        assertEquals(new Person("Hugo", "Reyes", 27), list.get(0));
        assertEquals(new Person("Linus", "Ben", 33), list.get(1));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testAddByIndex() throws Exception {
        list.add(new Person("Hugo", "Reyes", 27));
        list.add(new Person("Linus", "Ben", 33));
        list.add(1, new Person("Ololo", "Lol", 33));
        assertTrue(list.size() == 3);
        assertEquals(new Person("Hugo", "Reyes", 27), list.get(0));
        assertEquals(new Person("Ololo", "Lol", 33), list.get(1));
        assertEquals(new Person("Linus", "Ben", 33), list.get(2));
    }

    @Test
    public void testGet() throws Exception {
        list.add(new Person("Jack", "Shepard", 30));
        assertEquals(new Person("Jack", "Shepard", 30), list.get(0));
    }

    @Test
    public void testSet() throws Exception {
        list.add(new Person("Jack", "Shepard", 30));
        list.set(0, new Person("Ololo", "Lol", 33));
        assertEquals(new Person("Ololo", "Lol", 33), list.get(0));
        assertTrue(list.size() == 1);
    }


    @Test
    public void testRemove() throws Exception {
        list.add(new Person("John", "Lock", 50));
        list.add(new Person("Jack", "Shepard", 30));
        Object obj = list.remove(0);
        assertTrue(obj.equals(new Person("John", "Lock", 50)));
        assertTrue(list.size() == 1);
        assertEquals(new Person("Jack", "Shepard", 30), list.get(0));
    }

    @Test
    public void testClear() throws Exception {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() throws Exception {
        list.add(new Person("John", "Lock", 50));
        list.add(new Person("Jack", "Shepard", 30));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add(new Person("John", "Lock", 50));
        list.add(new Person("Jack", "Shepard", 30));
        list.add(new Person("John", "Lock", 50));
        assertTrue(list.indexOf(new Person("John", "Lock", 50)) == 0);
    }

    @Test
    public void testLastIndexOf() throws Exception {
        list.add(new Person("John", "Lock", 50));
        list.add(new Person("Jack", "Shepard", 30));
        list.add(new Person("John", "Lock", 50));
        assertTrue(list.lastIndexOf(new Person("John", "Lock", 50)) == 2);
    }

    @Test
    public void testContains() throws Exception {
        list.add(new Person("John", "Lock", 50));
        assertTrue(list.contains(new Person("John", "Lock", 50)));
        assertFalse(list.contains(new Person("aaa", "zzz", 22)));
    }
}
