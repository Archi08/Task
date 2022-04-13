package api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTokenBody {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public enum DeviceOs {
        ANDROID,
        IOS
    }

    public enum AppLocale {
        de_DE,
        en_GB
    }
}