package specs.theInternet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
    // Có 2 dạng: select 1 item, và select nhiều items

    /**
     * Select option
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/dropdown
     * Select "option 1"
     * Validate "option 1" is selected
     */

    @Test
    void selectOption1Successfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Option 1");

        //Có 3 cách dùng select
        select.selectByVisibleText("Banana");//Nên dùng cách này
        select.selectByVisibleText("Apple");
        select.selectByIndex(1);
        select.selectByValue("1");

        WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']//option[.='Option 1']"));

        Assert.assertTrue(option1.isSelected());
    }

    @Test
    void validateSelectMultiOptionSelect() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        //Có 3 cách dùng select
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());
    }
}


