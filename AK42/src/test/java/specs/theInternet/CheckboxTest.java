package specs.theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

/** Test case:
 * Check to a box
 * Open browser
 * Navigate to https://the-internet.herokuapp.com/checkboxes
 * Check on checkbox1
 * Verify checkbox1 is checked
 * Check on checkbox2
 * Verify checkbox2 is checked
 */

public class CheckboxTest {

    public static WebDriver webDriver;

    //Bài Abie làm
    @Test
    void validateCheckBoxSuccessfully(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/checkboxes");

       WebElement checkbox1Element = webDriver.findElement(By.xpath("//input[@type='checkbox'])[1]"));
       if(!checkbox1Element.isSelected()) {
           checkbox1Element.click();
       }
        Assert.assertTrue(checkbox1Element.isSelected());

        WebElement checkbox2Element = webDriver.findElement(By.xpath("//input[@type='checkbox'])[2]"));
        if(!checkbox2Element.isSelected()) {
            checkbox2Element.click();
        }
        Assert.assertTrue(checkbox2Element.isSelected());
    }

    @Test
    void validateCheckBoxSuccessfullyCSS(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1Element = webDriver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));
        if(!checkbox1Element.isSelected()) {
            checkbox1Element.click();
        }
        Assert.assertTrue(checkbox1Element.isSelected());

        WebElement checkbox2Element = webDriver.findElement(By.cssSelector("#checkboxes input:nth-child(3)"));
        if(!checkbox2Element.isSelected()) {
            checkbox2Element.click();
        }
        Assert.assertTrue(checkbox2Element.isSelected());
    }

    //Dùng cách này
    @Test
    void validateCheckboxSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        check(checkbox1);
        Assert.assertTrue(isChecked(checkbox1));

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        check(checkbox2);
        Assert.assertTrue(isChecked(checkbox2));
    }

    @Test
    void validateCheckBoxByFindElements(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        for (WebElement checkbox: checkboxes) {
            check(checkbox);
            Assert.assertTrue(isChecked(checkbox));
        }
    }

    //Gọi là Selenium Owner Method (có thể sử dụng lại từ 2 lần, nên tách Method ra)
    public static void check(WebElement element){
        if(!isChecked(element)){
        //if(!element.isSelected()){
            element.click();
        }
    }

    public static void uncheck(WebElement element) {
        if (isChecked(element)) {
            element.click();
        }
    }
        public static boolean isChecked (WebElement element){
            return element.getAttribute("checked").equals("true");
        }


    //Method chạy sau mỗi TCs
    @AfterMethod (alwaysRun = true)
    void closeBrowser(){
        webDriver.quit();
    }
}

