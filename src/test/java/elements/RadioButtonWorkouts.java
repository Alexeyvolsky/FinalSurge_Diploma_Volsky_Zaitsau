package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonWorkouts extends BaseElement{
    private final static String RADIOBUTTON_FOR_WORKOUTS = "//span[text()='Great']//ancestor::label//input";

    public RadioButtonWorkouts(WebDriver driver) {
        super(driver);
    }
    public void clickRadiobuttonWorkouts(String value){
        WebElement radiobutton = driver.findElement(By.xpath(String.format(RADIOBUTTON_FOR_WORKOUTS, value)));
        scrollIntoView(radiobutton);
        radiobutton.click();
    }
}
