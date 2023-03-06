package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class Input extends BaseElement{

    public Input(WebDriver driver) {
        super(driver);
    }
    public void setValue(String id, String value){
        log.info(String.format("setting input: value = %s", value));
        WebElement input = driver.findElement(By.id(id));
        scrollIntoView(input);
        input.sendKeys(value);
    }
    public void clearAndSetValue(String id, String value){
        log.info(String.format("setting input: value = %s", value));
        WebElement input = driver.findElement(By.id(id));
        scrollIntoView(input);
        input.clear();
        input.sendKeys(value);
    }

    public void jsSetValue(String id, String value)    {
        log.info(String.format("js send value %s, %s ", id, value));
        jsSendKeysInSettings(id, value);
    }
    public void setValueCard(By locator, String value) {
        log.info(String.format("setting input: value = %s", value));
        WebElement input = driver.findElement(locator);
        input.sendKeys(value);
    }
}
