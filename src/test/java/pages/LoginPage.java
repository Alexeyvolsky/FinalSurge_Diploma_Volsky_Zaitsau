package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final static By EMAIL_INPUT = By.id("login_name");
    private final static By PASSWORD_INPUT = By.id("login_password");
    private final static By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private final static By LOGOUT_BUTTON = By.xpath("//div[@class='alert alert-success']");

    @Step("Set email on login page")
    public void setEmailInput(String email){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Set password on login page")
    public void setPasswordInput(String password){
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Verify that login button is displayed")
    public boolean isLoginButtonPresent() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Verify that logout message is displayed")
    public boolean logoutMessagePresent(){
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
