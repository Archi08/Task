package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public
interface ServerConfig extends Config {

    @Key("url")
    String url();

    @Key("email")
    String email();

    @Key("password")
    String password();

    @Key("apiUrl")
    String apiUrl();

    @Key("username")
    String username();

    @Key("passwordApi")
    String passwordApi();

    @Key("apiKey")
    String apiKey();

    @Key("bookingsPath")
    String bookingsPath();

    @Key("bookingPath")
    String bookingPath();
}
