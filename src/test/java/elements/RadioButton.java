package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class RadioButton extends BaseElement{

    private final static String RADIOBUTTON_LOCATOR = "//input[@name='%s' and @value='%s']";
    public RadioButton(WebDriver driver) {
        super(driver);
    }
    public void clickRadiobutton(String name, String value){
        log.info(String.format("selecting radio button: value = %s", value));
        WebElement radiobutton = driver.findElement(By.xpath(String.format(RADIOBUTTON_LOCATOR, name, value)));
        scrollIntoView(radiobutton);
        radiobutton.click();
    }
}
