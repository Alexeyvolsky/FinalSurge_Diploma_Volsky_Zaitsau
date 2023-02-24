package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElementValue extends BaseElement    {

    private String label;
    private final static String LOCATOR_FOR_ELEMENTS_DETAILS = "//div[@class='span10']//small[text()='%s']//ancestor::p";

    public GetElementValue(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public String getValue()    {
        WebElement characteristics = driver.findElement(By.xpath(String.format(LOCATOR_FOR_ELEMENTS_DETAILS, this.label)));
        scrollIntoView(characteristics);
        return characteristics.getText();
    }
}