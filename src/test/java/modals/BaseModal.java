package modals;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public abstract class BaseModal extends BasePage {
    public BaseModal(WebDriver driver) {
        super(driver);
    }
}