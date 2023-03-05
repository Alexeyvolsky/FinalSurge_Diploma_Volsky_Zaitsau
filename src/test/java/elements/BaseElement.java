package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class BaseElement {
    protected WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollIntoView(WebElement element) {
        log.info(String.format("scrolling to element %s ", element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void jsSendKeysInSettings(String name, String value) {
        log.info(String.format("js send value %s, %s ", name, value));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.getElementById('"+name+"').value='"+value+"'");
    }
}
