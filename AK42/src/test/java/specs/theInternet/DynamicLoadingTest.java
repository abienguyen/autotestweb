package specs.theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DynamicLoadingTest {
    WebDriver driver;
    WebDriverWait wait;
    int MAX_TIMEOUT_SECONDS = 10;// Hằng số đặt đầu tiên và viết IN HOA

    @BeforeClass
    void setUP(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    void validateResult() {

        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // waiting approach => per page

        String finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).getText();
        Assert.assertEquals(finish,"Hello World!");

    }

    @AfterMethod
    void captureScreenshotWhenFail(ITestResult testResult){
        //Folder chụp hình lưu lại khi TCs FAILED
        if(!testResult.isSuccess()){
            Instant instant = Instant.ofEpochMilli(testResult.getStartMillis());
            ZoneId zoneId = ZoneId.systemDefault(); // Use the system default time zone
            LocalDate localDate = instant.atZone(zoneId).toLocalDate();

            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile=new File(String.format("target/%s-%s.png",testResult.getName(),localDate));
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
