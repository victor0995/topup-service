package uz.ucell.topupservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class MessageResponse implements Serializable {

    private String id;

    private Integer status;

    @JsonCreator
    public MessageResponse(
            @JsonProperty("status") int status,
            @JsonProperty("id") String id) {
        this.status = status;
        this.id = id;
    }
}
