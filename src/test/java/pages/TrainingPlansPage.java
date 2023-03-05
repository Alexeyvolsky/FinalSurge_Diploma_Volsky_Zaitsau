package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class TrainingPlansPage extends BasePage{

    private final static By TRAINING_TYPES_IMAGE=By.xpath("//img[@alt='Sport types']");
    private final static By TRAINING_PLAN_BUTTON=By.xpath("//div[@class='training-plan-list-item__name text-xl']");

    public TrainingPlansPage(WebDriver driver) {
        super(driver);
    }
    @Step("Verifying that training types image is displayed")
    public boolean isTrainingTypesImagePresent() {
        log.info("verifying that training types image is displayed");
        return driver.findElement(TRAINING_TYPES_IMAGE).isDisplayed();
    }
    @Step ("Clicking a chosen training plan")
    public void clickTrainingPlan() {
        log.info("clicking a chosen training plan");
        List<WebElement> planLinks=driver.findElements(TRAINING_PLAN_BUTTON);
        WebElement button = planLinks.get(2);
        scrollIntoView(button);
        jsClick(button);
    }
}
