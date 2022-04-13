package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class TicketPage {

    @FindBy(css = ".infobox infobox-success")
    private SelenideElement infobox;

}
