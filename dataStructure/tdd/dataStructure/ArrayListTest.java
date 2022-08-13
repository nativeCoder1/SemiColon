package dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    List list;
    @BeforeEach
    void setUp(){
        list = new ArrayList();
    }
    @Test
    void testThatNewListIsEmpty(){
        assertTrue(list.isEmpty());
    }
    @Test
    void addItemToListIsNotEmptyTest(){
        list.add("Item 1");
        assertFalse(list.isEmpty());
    }
    @Test
    void addItemIsNotEmpty_SizeIsOne(){
        list.add("Item 1");
        assertEquals(1, list.size());
    }
    @Test
    void addItem_GetByIndex(){
        list.add("Item-1");
        list.add("Item-2");
        String savedItem = list.get(0);
        assertEquals("Item-1", savedItem);
        assertEquals("Item-2", list.get(1));
    }
    @Test
    void addXYgetXY(){
        list.add("Item-1");
        list.add("Item-2");
        assertEquals("Item-1", list.get(0));
        assertEquals("Item-2", list.get(1));
    }
    @Test
    void addXYremoveXYSizeIsOneTest(){
        list.add("Item-1");
        list.add("Item-2");
        list.remove(0);
        assertNull(list.get(0));
        assertEquals(1, list.size());
    }
    @Test
    void addXYremoveYFindByIndexIsNullTest(){
        list.add("Item-1");
        list.add("Item-2");
        list.remove(1);
        String deletedItem = list.get(1);
        assertNull(deletedItem);
    }
    @Test
    void addXToIndex_ListIsNotEmpty(){
        list.add(0, "Item-1");
        assertFalse(list.isEmpty());
    }
    @Test
    void addItemToIndex_SizeIsOne(){
        list.add(0, "Item 1");
        assertEquals(1, list.size());
    }
    @Test
    void addItemToIndex_GetByIndex(){
        list.add(0, "Item-1");
        String savedItem = list.get(0);
        assertEquals("Item-1", savedItem);
    }
    @Test
    void addXYtoIndexGetXY(){
        list.add(0, "Item-1");
        list.add(1, "Item-2");
        assertEquals("Item-1", list.get(0));
        assertEquals("Item-2", list.get(1));
    }
    @Test
    void addToAParticularIndex(){
        list.add(0, "Item-1");
        list.add(1, "Item-2");
        list.add(2, "Item-3");
        list.add(2, "Item-4");
        list.add(4, "Item-5");
        assertEquals("Item-5", list.get(4));
        //assertEquals(5, list.size());
    }
    @Test
    void addXYtoIndexRemoveXY_SizeIsOneTest(){
        list.add("Item-1");
        list.add("Item-2");
        list.remove(0);
        assertEquals(1, list.size());
    }
    @Test
    void addXYremoveYByName_FindByIndexIsNullTest(){
        list.add("Item-1");
        list.add("Item-2");
        list.remove("Item-1");
        String deletedItem = list.get(0);
        assertNull(deletedItem);
    }

    @Test
    void addXY_replaceY(){
        list.add("Item-1");
        list.add("Item-2");
        list.set(1, "New_item");
        assertEquals("New_item", list.get(1));
    }
    @Test
    void testThatArrayContainsX(){
        list.add("Item-1");
        assertTrue(list.contains("Item-1"));
    }
    @Test
    void testThatArrayContainsXY(){
        list.add("Item-1");
        list.add("Item-2");
        assertTrue(list.contains("Item-2"));
        assertTrue(list.contains("Item-1"));
    }
    @Test
    void testThatArrayIsEmpty_AfterClearing(){
        list.add("Item-1");
        list.add("Item-2");
        list.clear();
        assertTrue(list.isEmpty());
    }
    @Test
    void testThatSizeIsZeroAfterClearingArray(){
        list.add("Item-1");
        list.add("Item-2");
        list.clear();
        assertEquals(0, list.size());
    }
    @Test
    void testThatXYDoesNotExistAfterClearingArray(){
        list.add("Item-1");
        list.add("Item-2");
        list.clear();
        assertNull(list.get(0));
        assertNull(list.get(1));
    }
}
