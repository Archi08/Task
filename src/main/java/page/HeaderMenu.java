package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class HeaderMenu {
    @FindBy(linkText = "Home")
    private WebElement lkHome;

    @FindBy(linkText = "Hotels")
    private WebElement lkHotels;

    @FindBy(linkText = "Flights")
    private SelenideElement lkFlights;

    @FindBy(linkText = "Tours")
    private WebElement lkTours;

    @FindBy(linkText = "Cars")
    private WebElement lkCars;

    @FindBy(linkText = "Visa")
    private WebElement lkVisa;

    @FindBy(linkText = "Blog")
    private WebElement lkBlog;

    @FindBy(xpath = ".//button[normalize-space(text())='Account']")
    private WebElement account;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboard;
}
