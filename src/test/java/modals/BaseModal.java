package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Log4j2
public abstract class BaseModal extends BasePage {

    protected void openIframe(By locator)    {
        log.debug("opening iframe");
        WebElement iframe = driver.findElement(locator);
        driver.switchTo().frame(iframe);
    }

    public BaseModal(WebDriver driver) {
        super(driver);
    }
}