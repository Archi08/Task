package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//button[normalize-space(.)='Login']")
    private WebElement btnLogin;

    @FindBy(name = "email")
    private WebElement tbEmail;

    @FindBy(name = "password")
    private WebElement tbPassword;

    public void login(String email, String password) {
        tbEmail.sendKeys(email);
        tbPassword.sendKeys(password);
        btnLogin.click();
    }

}
