package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class WorkoutsPage extends BasePage{
    private final static By SIDEBAR = By.cssSelector(".aw_sidebar");
    private final static String ACTIVE_TYPE_BUTTON = "//a[@data-code='%s']";
    private final static String ACCORDING_INNER = "//div[@class='accordion-inner']//a[text()='%s']";

    @Step("Verify that sidebar is displayed")
    public boolean isSidebarPresent(){
        log.info("verifying that sidebar is display");
        return driver.findElement(SIDEBAR).isDisplayed();
    }

    @Step("Click activity type button run")
    public void clickActiveTypeButtonRun(){
        log.info("clicking activity type button run");
        driver.findElement(By.xpath(String.format(ACTIVE_TYPE_BUTTON,"run"))).click();
    }

    @Step("Click activity type button rest")
    public void clickActiveTypeButtonRest(){
        log.info("clicking activity type button rest");
        driver.findElement(By.xpath(String.format(ACTIVE_TYPE_BUTTON,"rest"))).click();
    }

    @Step("Click according inner button")
    public void clickAccordingInnerButton(){
        log.info("clicking according inner button");
        driver.findElement(By.xpath(String.format(ACCORDING_INNER, "Hills"))).click();
    }

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }
}
