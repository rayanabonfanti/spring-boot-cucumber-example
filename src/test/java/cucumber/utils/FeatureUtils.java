package cucumber.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.model.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;

public class FeatureUtils {
    public static String URL = "http://localhost:9000";
    public static Person getMockPerson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Person.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
