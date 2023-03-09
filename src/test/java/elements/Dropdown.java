package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
@Log4j2
public class Dropdown extends BaseElement{
    private final static String DROPDOWN_LOCATOR = "//select[@name='%s']";

    public Dropdown(WebDriver driver) {
        super(driver);
    }

    public void selectOptionByValue(String name, String optionName) {
        log.info(String.format("selecting option: option name = %s", optionName));
        Select dropdown = new Select(driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, name))));
        dropdown.selectByValue(optionName);

    }
    public void selectOptionByText(String name, String optionName)   {
        log.info(String.format("selecting option: option name = %s", optionName));
        Select select = new Select(driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, name))));
        select.selectByVisibleText(optionName);
    }
}