package api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
//@JsonSerialize
//@JsonIgnoreProperties({ "flights", "accomodation", "status" })
public class Booking {

    @JsonProperty("bookingRef")
    private String bookingRef;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("country")
    private String country;

    @JsonProperty("status")
    private String status;

    @JsonProperty("flights")
    private List<Flight> flights;

    @JsonProperty("accomodation")
    private List<Accomodation> accomodation;

}