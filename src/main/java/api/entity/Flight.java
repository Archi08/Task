package api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class Flight {

    @JsonProperty("flightOperator")
    private String flightOperator;

    @JsonProperty("departureDatetime")
    private String departureDatetime;

    @JsonProperty("departureAirport")
    private String departureAirport;

    @JsonProperty("arrivalDatetime")
    private String arrivalDatetime;

    @JsonProperty("arrivalAirport")
    private String arrivalAirport;

    @JsonProperty("type")
    private String type;


}
