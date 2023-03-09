package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
@Log4j2
public class PrintDetailsPage extends BasePage   {

    private final static By WORKOUTS_DATA = By.xpath("//td/span[2]");

    public boolean isPrintDetailsPageIsPresent()    {
        log.debug("verifying that print details page is displayed");
        try {
            driver.findElement(WORKOUTS_DATA).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Get print workout data")
    public PrintWorkout getPrintWorkoutData()  {
        log.info("getting print workout data");
        PrintWorkout.PrintWorkoutBuilder printWorkout = PrintWorkout.builder()
                .setWorkoutsData(driver.findElement(WORKOUTS_DATA).getText());
        return printWorkout.build();
    }

    @Step("Switch between tabs")
    public void switchBetweenTabs(int tab)  {
        log.info(String.format("switching between tabs: %s", tab));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public PrintDetailsPage(WebDriver driver) {
        super(driver);
    }
}