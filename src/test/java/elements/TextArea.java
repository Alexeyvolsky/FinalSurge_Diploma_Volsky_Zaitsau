package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea extends BaseElement{
    private final static String TEXTAREA_LOCATOR = "%s";

    public TextArea(WebDriver driver) {
        super(driver);
    }
    public void setValue(String id, String value){
        WebElement textArea = driver.findElement(By.id(String.format(TEXTAREA_LOCATOR, id)));
        scrollIntoView(textArea);
        textArea.sendKeys(value);
    }
}
