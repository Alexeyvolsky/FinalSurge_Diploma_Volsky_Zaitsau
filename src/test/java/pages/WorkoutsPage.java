package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutsPage extends BasePage{
    private final static By SIDEBAR = By.cssSelector(".aw_sidebar");
    private final static String ACTIVE_TYPE_BUTTON = "//a[@data-code='%s']";
    private final static String ACCORDING_INNER = "//div[@class='accordion-inner']//a[text()='%s']";

    @Step("Verify that sidebar is displayed")
    public boolean isSidebarPresent(){
        return driver.findElement(SIDEBAR).isDisplayed();
    }

    @Step("Click activity type button run")
    public void clickActiveTypeButtonRun(){
        driver.findElement(By.xpath(String.format(ACTIVE_TYPE_BUTTON,"run"))).click();
    }

    @Step("Click activity type button rest")
    public void clickActiveTypeButtonRest(){
        driver.findElement(By.xpath(String.format(ACTIVE_TYPE_BUTTON,"rest"))).click();
    }

    @Step("Click according inner button")
    public void clickAccordingInnerButton(){
        driver.findElement(By.xpath(String.format(ACCORDING_INNER, "Hills"))).click();
    }

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }
}
