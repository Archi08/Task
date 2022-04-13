package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlyForm {

    private String from;
    private String to;
    private String date;
    private String countPassengers;

}