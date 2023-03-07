package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage{

    private final static By EMAIL_INPUT = By.id("login_name");
    private final static By PASSWORD_INPUT = By.id("login_password");
    private final static By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private final static By LOGOUT_BUTTON = By.xpath("//div[@class='alert alert-success']");

    @Step("Set email on login page")
    public void setEmailInput(String email){
        log.info(String.format("entering email on login page: %s", email));
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Set password on login page")
    public void setPasswordInput(String password){
        log.info(String.format("entering password on login page: %s", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton(){
        log.info("clicking login button");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public boolean isLoginButtonPresent() {
        log.debug("verifying that login button is displayed");
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public boolean logoutMessagePresent(){
        log.debug("verifying that logout message is displayed");
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
