package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement{

    public Input(WebDriver driver) {
        super(driver);
    }
    public void setValue(String id, String value){
        WebElement input = driver.findElement(By.id(id));
        scrollIntoView(input);
        input.sendKeys(value);
    }
    public void clearAndSetValue(String id, String value){
        WebElement input = driver.findElement(By.id(id));
        scrollIntoView(input);
        input.clear();
        input.sendKeys(value);
    }

    public void jsSetValet(String id, String value)    {
        jsSendKeysInSettings(id, value);
    }
}
