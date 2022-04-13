import com.codeborne.selenide.Condition;
import config.ServerConfig;
import entity.FlyForm;
import entity.User;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import page.*;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseSteps {

    private LoginPage loginPage = page(LoginPage.class);
    private DashboardPage dashboardPage = page(DashboardPage.class);
    private HeaderMenu headerMenu = page(HeaderMenu.class);
    private FlightsPage flightsPage = page(FlightsPage.class);
    private TicketPage ticketPage = page(TicketPage.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Step("Buy Ticket")
    public void bookedFlyTicket(String url, User user, FlyForm form) {
        open(url);
        loginPage.login(user.getEmail(), user.getPassword());
        headerMenu.getLkFlights().click();
        flightsPage.fillFlightForm(form);
        flightsPage.getSearchButton().click();
    }

    @Step("Check Ticket")
    public void checkBookedTicket() {
        headerMenu.getAccount().click();
        headerMenu.getDashboard().click();
        dashboardPage.getMyBookings().click();
        dashboardPage.getLastVoucher();
        ticketPage.getInfobox().shouldHave(Condition.text("Confirmed"));
        ticketPage.getInfobox().shouldHave(Condition.text("Paid"));
    }
}