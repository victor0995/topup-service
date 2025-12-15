package uz.ucell.topupservice.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IntegerDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jp, DeserializationContext txt) {
        try {
            String value = jp.getText();

            if (value == null || value.isBlank())
                return null;

            return Integer.valueOf(value.trim());

        } catch (Exception e) {
            return null;
        }
    }
}