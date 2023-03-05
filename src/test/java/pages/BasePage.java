package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        this.faker = new Faker();
    }
    @Step("Wait for element displayed")
    protected void waitForElementDisplayed(By elementLocator) {
        log.info(String.format("Wait is displayed element:  %s ", elementLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
    @Step("Javascript click")
    protected void jsClick(WebElement element) {
        log.info(String.format("Javascript click at element:  %s ", element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void scrollIntoView(WebElement element) {
        log.info(String.format("scrolling to element %s ", element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
