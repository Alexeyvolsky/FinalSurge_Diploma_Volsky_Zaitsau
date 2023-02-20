package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement{
    private final static String DROPDOWN_LOCATOR = "//select[@name='%s']";

    public Dropdown(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String name, String optionName) {
        Select dropdown = new Select(driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, name))));
        dropdown.selectByValue(optionName);

    }
    public void selectOptionByText(String name, String optionName)   {
        Select select = new Select(driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, name))));
        select.selectByVisibleText(optionName);
    }

}