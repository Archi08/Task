import api.BookingService;
import api.entity.Booking;
import api.entity.Bookings;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ServerConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("API")
public class BookingApiTest {

    private static BookingService bookingService;
    private static ObjectMapper objectMapper;
    private ValidatableResponse response;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeAll
    public static void setUp() {
        bookingService = new BookingService();
        objectMapper = new ObjectMapper();
    }

    @Test
    @Description("Check methods get bookings")
    public void checkBookings() throws Exception {
        Bookings expectedBookings = objectMapper.readValue(
                new File(cfg.bookingsPath()), Bookings.class);
        bookingService.getAuthToken();
        response = bookingService.getBookings();
        Bookings actualBookings = response.extract().body().as(Bookings.class);
        Assertions.assertEquals(response.extract().statusCode(), 200);
        Assertions.assertEquals(actualBookings, expectedBookings);
    }

    @Test
    @Description("Check methos get bookings by Id")
    public void checkBookingsById() throws Exception {
        Booking expectedBooking = objectMapper.readValue(
                new File(cfg.bookingPath()), Booking.class);
        bookingService.getAuthToken();
        String bookingId = bookingService.getBookings().extract().body()
                .as(Bookings.class).getBookings().get(0).getBookingRef();
        response = bookingService.getBookingById(bookingId);
        Booking actualBooking = response.extract().body().as(Booking.class);
        Assertions.assertEquals(response.extract().statusCode(), 200);
        Assertions.assertEquals(actualBooking, expectedBooking);
    }




}
