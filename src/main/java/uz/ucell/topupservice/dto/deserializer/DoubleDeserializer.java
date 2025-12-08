package uz.ucell.topupservice.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DoubleDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jp, DeserializationContext txt) {
        try {
            String v = jp.getText();
            if (v == null || v.isBlank())
                return null;

            return Double.valueOf(v.trim());
        } catch (Exception e) {
            return null;
        }
    }
}
