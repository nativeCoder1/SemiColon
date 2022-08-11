package tddClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDrillerTest {
    TestDriller testDriller;
    @BeforeEach
    void setUp(){
        testDriller = new TestDriller();
    }
    @Test
    @DisplayName("Test cost for 1-4 copies")
    void testCostOf1to4Copies(){
        //when
        int cost = testDriller.priceRange(4);
        //check
        assertEquals(8000, cost);
    }
    @Test
    @DisplayName("Test price range for 5-9 copies")
    void testCostOf5to9Copies(){
        //when
        int cost = testDriller.priceRange(6);
        //check
        assertEquals(10800, cost);
    }
    @Test
    @DisplayName("Test price range for 10-29 copies")
    void testCostOf10to29Copies(){
        //when
        int cost = testDriller.priceRange(10);
        //check
        assertEquals(16000, cost);
    }
    @Test
    @DisplayName("Test price range for 30-49 copies")
    void testCostOf30to49Copies(){
        //when
        int cost = testDriller.priceRange(3);
        //check
        assertEquals(6000, cost);
    }
    @Test
    @DisplayName("Test price range for 50-99 copies")
    void testCostOf50to99Copies(){
        //when
        int cost = testDriller.priceRange(58);
        //check
        assertEquals(75400, cost);
    }
    @Test
    @DisplayName("Test price range for 100-199 copies")
    void testCostOf100to199Copies(){
        //when
        int cost = testDriller.priceRange(100);
        //check
        assertEquals(120000, cost);
    }
    @Test
    @DisplayName("Test price range for 200-499 copies")
    void testCostOf200to499Copies(){
        //when
        int cost = testDriller.priceRange(200);
        //check
        assertEquals(220000, cost);
    }
    @Test
    @DisplayName("Test price range for 500 and above copies")
    void testCostOf500AndAboveCopies(){
        //when
        int cost = testDriller.priceRange(500);
        //check
        assertEquals(500000, cost);
    }
}
