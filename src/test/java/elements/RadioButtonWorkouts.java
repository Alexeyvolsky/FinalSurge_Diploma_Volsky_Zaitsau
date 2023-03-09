package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class RadioButtonWorkouts extends BaseElement{
    private final static String RADIOBUTTON_FOR_WORKOUTS = "//span[text()='%s']//ancestor::label//input";

    public RadioButtonWorkouts(WebDriver driver) {
        super(driver);
    }
    public void clickRadiobutton(String value){
        log.info(String.format("selecting radio button: value = %s", value));
        WebElement radiobutton = driver.findElement(By.xpath(String.format(RADIOBUTTON_FOR_WORKOUTS, value)));
        scrollIntoView(radiobutton);
        radiobutton.click();
    }
}
