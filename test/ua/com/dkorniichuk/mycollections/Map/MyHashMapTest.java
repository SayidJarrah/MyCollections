package ua.com.dkorniichuk.mycollections.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyHashMapTest {
    Map<String, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    public void testPut() {
        map.put("January", "Winter");
        map.put("February", "Winter");
        map.put("April", "Spring");
        map.put("April", "Spring.v2");
        //  assertTrue(map.size() == 3);
        assertEquals("Winter", map.get("January"));
        assertEquals("Spring.v2", map.get("April"));

    }

    @Test
    public void testGet() {
        map.put("January", "Winter");
        map.put("April", "Spring");
        assertEquals("Spring", map.get("April"));

    }

    @Test
    public void testRemove() {
        map.put("January", "Winter");
        map.put("April", "Spring");
        assertEquals("Winter", map.remove("January"));
        assertTrue(map.size() == 1);

    }

    @Test
    public void testKeys() {
        map.put("January", "Winter");
        map.put("April", "Spring");

        assertTrue(map.keys().size() == 2);
        assertTrue(map.keys().contains("January") && map.keys().contains("April"));

    }

    @Test
    public void testPutIfAbsence() {
        map.put("January", "Winter");
        map.put("April", "Spring");
        map.putIfAbsent("April", "SecondMonth");
        map.putIfAbsent("May", "Spring");

    }

    @Test
    public void testContainsKey() {
        map.put("January", "Winter");
        map.put("April", "Spring");
        assertTrue(map.containsKey("April") == true);
    }

    @Test
    public void testContainsValue() {
        map.put("January", "Winter");
        map.put("April", "Spring");
        assertTrue(map.containsValue("Winter") == true);
    }

    @Test
    public void testPutAll() {
        map.put("1", "111");
        map.put("2", "222");
        map.put("3", "222");
        map.put("4", "222");
        MyHashMap<String, String> map2 = new MyHashMap();
        map2.put("1", "111");
        map2.put("3", "333");
        map2.put("5", "555");

        map.putAll(map2);
        assertTrue(map.size() == 5);
    }

    @Test
    public void testClear() {
        map.put("1", "111");
        map.put("2", "222");
        map.clear();

    }
}