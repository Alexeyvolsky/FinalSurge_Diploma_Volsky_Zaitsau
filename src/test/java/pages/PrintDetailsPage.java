package pages;

import io.qameta.allure.Step;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class PrintDetailsPage extends BasePage   {

    private final static By WORKOUTS_DATA = By.xpath("//td/span[2]");

    @Step("Verify that print details page is displayed")
    public boolean isPrintDetailsPageIsPresent()    {
        try {
            driver.findElement(WORKOUTS_DATA).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Get print workout data")
    public PrintWorkout getPrintWorkoutData()  {
        PrintWorkout.PrintWorkoutBuilder printWorkout = PrintWorkout.builder()
                .setWorkoutsData(driver.findElement(WORKOUTS_DATA).getText());
        return printWorkout.build();
    }

    @Step("Switch between tabs")
    public void switchBetweenTabs(int tab)  {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public PrintDetailsPage(WebDriver driver) {
        super(driver);
    }
}