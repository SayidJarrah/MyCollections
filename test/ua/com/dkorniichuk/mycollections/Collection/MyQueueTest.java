package ua.com.dkorniichuk.mycollections.Collection;

import org.junit.Before;
import org.junit.Test;
import ua.com.dkorniichuk.mycollections.Model.Person;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyQueueTest {
    Queue<Person> queue;

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testAdd() {
        queue.add(new Person("Hugo", "Reyes", 27));
        queue.add(new Person("Linus", "Ben", 33));

        assertTrue(queue.size() == 2);
    }

    @Test
    public void testPeek() {

        Person[] expectedArray = {new Person("Hugo", "Reyes", 27), new Person("Linus", "Ben", 33)};
        for (Person value : expectedArray) {
            queue.add(value);
        }

        for (Person expectedString : expectedArray) {
            assertEquals(expectedString, queue.peek());
        }
        assertNull(queue.poll());
    }


    @Test
    public void testSize() {
        assertEquals(0, queue.size());

    }

    @Test
    public void testPoll() {
        queue.add(new Person("Hugo", "Reyes", 27));
        queue.add(new Person("Linus", "Ben", 33));

        assertTrue(queue.poll().equals(new Person("Hugo", "Reyes", 27)));
    }
}