package base;

import org.openqa.selenium.WebDriver;
import supports.Browser;

// abstract class
public class BasePage {
    protected WebDriver driver;
    public BasePage() {
        driver = Browser.getDriver();
    }
}