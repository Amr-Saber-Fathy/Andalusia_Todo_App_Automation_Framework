package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonDataReader() {
        // prevent instantiation
    }

    public static List<Map<String, Object>> readJsonAsListOfMaps(String filePath) {
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Map<String, Object>>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}

