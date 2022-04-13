package api;

import api.entity.Booking;
import api.entity.Bookings;
import api.entity.GetTokenBody;
import config.ServerConfig;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

public class BookingService {

    private static RequestSpecification specification;
    private ValidatableResponse response;
    private static ServerConfig cfg;
    private String authToken;


     static {
        cfg = ConfigFactory.create(ServerConfig.class);
        specification = RestAssured.given()
                .baseUri(cfg.apiUrl())
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON);
    }

    @Step("Get auth token")
    public void getAuthToken() {
        GetTokenBody getTokenBody = GetTokenBody.builder()
                .username(cfg.username())
                .password(cfg.passwordApi())
                .build();

        authToken = specification.when()
                .headers("device-os", GetTokenBody.DeviceOs.ANDROID,
                        "app-locale", GetTokenBody.AppLocale.de_DE,
                                             "x-api-key", cfg.apiKey())
                .body(getTokenBody)
                .post("auth/login")
                .getHeader("login-token");
    }

    @Step("Get bookings")
    public ValidatableResponse getBookings() {
          return specification.when()
                 .headers("device-os", GetTokenBody.DeviceOs.ANDROID,
                         "app-locale", GetTokenBody.AppLocale.de_DE,
                         "x-api-key", cfg.apiKey(),
                         "login-token", authToken)
                  .get("v1/bookings")
                  .then();
    }

    @Step("Get booking by Id")
    public ValidatableResponse getBookingById(String bookingId) {
        return specification.when()
                .headers("device-os", GetTokenBody.DeviceOs.ANDROID,
                        "app-locale", GetTokenBody.AppLocale.de_DE,
                        "x-api-key", cfg.apiKey(),
                        "login-token", authToken)
                .get(format("v1/bookings/%s", bookingId))
                .then();
    }
}