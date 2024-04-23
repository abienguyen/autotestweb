package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import supports.Browser;

public class BaseTest {
    @AfterMethod
    protected void captureScreenShotWhenFail(ITestResult testResult){
        if(!testResult.isSuccess()){
            Browser.captureScreenshot(testResult);
        }
    }

    @AfterClass
    protected void tearDown(){
        Browser.quit();
    }
}