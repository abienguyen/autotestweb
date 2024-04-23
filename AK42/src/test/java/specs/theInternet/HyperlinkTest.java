package specs.theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HyperlinkTest {
    /**
     * Hyperlink - link text
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/status_codes
     * Click on "200"
     * Then "200 status code" page appear
     * Click on "go here"
     * Click on "301"
     * Then "301 status code" page appear
     * Click on "go here"
     * Click on "404"
     * Then "404 status code" page appear
     * Click on "go here"
     * Click on "500"
     * Then "500 status code" page appear
     * Click on "go here"
      */

    /**
     * <a href="status_codes/200">200</a> => gọi là Hyper link => dùng By.linkText()
     * Tag: a
     * Attreibutes:
     * href="status_codes/200" => css = a[href=status_code/200] or xpath = //a[@href='status_codes/200']
     * Text = 200 => driver.findElement(By.linkText("200"))
     */
    WebDriver browser;
    String baseUrl = "https://the-internet.herokuapp.com/status_codes";


    @BeforeClass
    void setUp() {
        browser = new ChromeDriver();
    }

    @BeforeMethod
    void openPage() {
        browser.get(baseUrl);
    }

    @Test
    void validateHyperlink200() {
        browser.findElement(By.linkText("200")).click();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl+"/200");

        goBackHome();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl);

        browser.findElement(By.linkText("301")).click();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl+"/301");

        goBackHome();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl);

        browser.findElement(By.linkText("404")).click();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl+"/404");

        goBackHome();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl);


        browser.findElement(By.linkText("500")).click();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl+"/500");

        goBackHome();
        Assert.assertEquals(browser.getCurrentUrl(), baseUrl);
    }
    void goBackHome(){
//        browser.findElement(By.linkText("here")).click();
        browser.navigate().back();
    }

    @AfterClass
    void tearDown() {
        browser.quit();
    }

}
