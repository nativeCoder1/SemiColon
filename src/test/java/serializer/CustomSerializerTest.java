package serializer;

import classes.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSerializerTest {
    private Cat cat;
    private String testJsonString;
    @BeforeEach
    void setUp() {
        cat = new Cat();
        cat.setName("Ologbo");
        cat.setAge(10);
        cat.setColor("red");
        testJsonString = "{\"name\":\"Ologbo\",\"age\":10,\"color\":\"red\"}";
    }
    @Test
    void testWriteCatToJson(){
        String expectedJsonResponse = "{\"name\":\"Ologbo\",\"age\":10,\"color\":\"red\"}";
        String catAsJson =  CustomSerializer.catToJson(cat);
        assertEquals(expectedJsonResponse, catAsJson);
    }
    @Test
    void testReadFromJson(){
        Cat deserializedJson = CustomSerializer.jsonToCat(testJsonString);
        assertNotNull(deserializedJson);
        assertEquals(cat, deserializedJson);
    }
}