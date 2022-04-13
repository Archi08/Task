import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ServerConfig;
import entity.FlyForm;
import entity.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

@Epic("UI")
@ExtendWith({TextReportExtension.class})
public class BookedFlyTicketTest {

    private User user;
    private FlyForm flyForm;
    private BaseSteps baseSteps;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeAll
    @Step("SetUp")
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        BasicConfigurator.configure();
    }

    @Test
    @Feature("Booked fly ticket")
    public void bookedFlyTicket() {
        baseSteps = new BaseSteps();
        String date = LocalDate.now().plusWeeks(1).toString();
        user = User.builder()
                .email(cfg.email())
                .password(cfg.password())
                .build();
        flyForm = FlyForm.builder()
                .from("HYD")
                .to("SIN")
                .date(date)
                .countPassengers("1")
                .build();
        baseSteps.bookedFlyTicket(cfg.url(), user, flyForm);
        baseSteps.checkBookedTicket();
    }
}