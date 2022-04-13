package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byText;

@Data
public class DashboardPage {

    @FindBy(xpath = ".//div[@class='sidebar-menu-wrap']/descendant::a[normalize-space(text())='Dashboard']")
    private WebElement dashboard;

    @FindBy(xpath = ".//div[@class='sidebar-menu-wrap']/descendant::a[normalize-space(text())='My Bookings']")
    private WebElement myBookings;

    @FindBy(xpath = ".//table")
    private SelenideElement listBooking;

    public void getLastVoucher() {
        listBooking.findElements(byText("flights"))
                .get(0)
                .findElement(By.xpath("following-sibling::td/descendant::a")).
                click();
    }

}
