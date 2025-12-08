package uz.ucell.topupservice.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.time.Instant;

public class InstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jp, DeserializationContext txt) {
        try {
            String text = jp.getText();

            if (text == null || text.isBlank())
                return null;

            return Instant.parse(text);

        } catch (Exception e) {
            return null;
        }
    }
}

