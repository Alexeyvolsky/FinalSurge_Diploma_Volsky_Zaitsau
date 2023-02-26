package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseElement{
    // TODO: locator
    private final static String RADIOBUTTON_LOCATOR = "//label[contains(text(),'%s')]/input";
    public RadioButton(WebDriver driver) {
        super(driver);
    }
    public void clickRadiobutton(String value){
        WebElement radiobutton = driver.findElement(By.xpath(String.format(RADIOBUTTON_LOCATOR, value)));
        scrollIntoView(radiobutton);
        radiobutton.click();
    }
}
