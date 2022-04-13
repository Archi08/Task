package api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@JsonIgnoreType
@Jacksonized
public class Room {

    @JsonProperty("roomType")
    private String roomType;

    @JsonProperty("guests")
    private List<Quest> guests;

    @JsonProperty("roomNumbers")
    private List<String> roomNumbers;

}
