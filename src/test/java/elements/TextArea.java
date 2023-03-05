package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class TextArea extends BaseElement{

    public TextArea(WebDriver driver) {
        super(driver);
    }
    public void setValue(String id, String value){
        log.info(String.format("setting textArea: value = %s", value));
        WebElement textArea = driver.findElement(By.id(id));
        scrollIntoView(textArea);
        textArea.sendKeys(value);
    }
}
