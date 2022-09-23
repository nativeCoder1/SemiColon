package serializer;

import classes.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class CustomSerializer {
    private static final ObjectMapper objMapper = new ObjectMapper();
    private static final Logger log = Logger.getGlobal();
    public static String catToJson(Cat cat) {
        try {
            String catAsJson = objMapper.writeValueAsString(cat);
            log.info(catAsJson);
            return catAsJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cat jsonToCat(String jsonString) {
        try {
            Cat jsonToCat = objMapper.readValue(jsonString, Cat.class);
            return jsonToCat;
        } catch(JsonProcessingException e){
                e.printStackTrace();
        }
        return null;
    }
}
