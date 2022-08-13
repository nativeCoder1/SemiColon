package dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    Stack stack;
    @BeforeEach
    public void setUp(){
        stack = new Stack();
    }
    @Test
    public void testThatNewStackIsEmpty(){
        assertTrue(stack.isEmpty());
    }
    @Test
    public void pushItemStackIsNotEmpty(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Dog");
        assertFalse(stack.isEmpty());
    }
    @Test
    public void pushItemToStack_SizeIsOne(){
        stack.push("Cat");
        int size = stack.size();
        assertEquals(1, size);
    }
    @Test
    public void pushItemToStack_getByIndex(){
        stack.push("Cat");
        String itemAtIndex = stack.get(0);
        assertEquals("Cat", itemAtIndex);
    }
    @Test
    public void pushItemXYZtoStack_getItemsXYZ(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        assertEquals("Dog", stack.get(0));
        assertEquals("Horse", stack.get(1));
        assertEquals("Cat", stack.get(2));
    }
    @Test
    public void pushXYZ_replaceY(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        stack.set(1, "Mosquito");
        assertEquals("Mosquito", stack.get(1));
    }
    @Test
    public void pushXYZtoStack_lastItemIsRemoved(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        String poppedItem = stack.pop();
        assertEquals("Cat", poppedItem);
    }
    @Test
    public void testThatPoppingReducesStackSize(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }
    @Test
    public void pushXYZtoStack_getZ(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        String itemAtTopOfStack = stack.peek();
        assertEquals("Cat", itemAtTopOfStack);
    }
    @Test
    public void testThatThePositionOfPushedItemsCanBeGotten(){
        stack.push("Dog");
        stack.push("Horse");
        stack.push("Cat");
        assertEquals(1, stack.search("Dog"));
    }
}


