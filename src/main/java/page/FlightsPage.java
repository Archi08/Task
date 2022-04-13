package page;

import entity.FlyForm;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class FlightsPage {

    @FindBy(xpath = ".//input[@placeholder='Flying From' and @id='autocomplete']")
    private WebElement flyFrom;

    @FindBy(xpath = ".//input[@placeholder='To Destination' and @id='autocomplete2']")
    private WebElement destenation;

    @FindBy(name = "depart")
    private WebElement departDateInput;

    @FindBy(xpath = ".//a[@data-toggle='dropdown']")
    private WebElement dropDown;

    @FindBy(name = "adults")
    private WebElement adultsInput;

    @FindBy(id = "flights-search")
    private WebElement searchButton;

    public void fillFlightForm(FlyForm form) {
        flyFrom.sendKeys(form.getFrom());
        destenation.sendKeys(form.getTo());
        departDateInput.sendKeys(form.getDate());
        dropDown.click();
        adultsInput.sendKeys(form.getCountPassengers());
    }



}
