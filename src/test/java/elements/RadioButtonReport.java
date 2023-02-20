package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonReport extends BaseElement{
    private final static String RADIOBUTTON_LOCATOR = "//label[text()='%s']";

    public RadioButtonReport(WebDriver driver) {
        super(driver);
    }

    public void clickReportRadiobutton(String value){
        WebElement radiobutton = driver.findElement(By.xpath(String.format(RADIOBUTTON_LOCATOR, value)));
        scrollIntoView(radiobutton);
        radiobutton.click();
    }
}
