package pages;

import base.BasePage;
import org.openqa.selenium.By;
import supports.Browser;

public class BMIPage extends BasePage {
    By metricTab = By.xpath("//a[.='Metric Units']");
    By clearBtn = By.cssSelector("[value=Clear]");
    By ageTxt = By.id("cage");
    By maleRadioBtn = By.id("csex1");
    By femaleRadioBtn = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By calculateBtn = By.cssSelector("[value=Calculate]");
    By resultLbl = By.cssSelector(".rightresult b");

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab(){
        driver.findElement(metricTab).click();
    }
    public void clearForm(){
        driver.findElement(clearBtn).click();
    }
    public void fillForm(String age,String gender,String height,String weight){
        driver.findElement(ageTxt).sendKeys(age);

        if(gender.equalsIgnoreCase("male")){
            Browser.check(maleRadioBtn);
        }else {
            Browser.check(femaleRadioBtn);
        }
        driver.findElement(heightTxt).sendKeys(height);
        driver.findElement(weightTxt).sendKeys(weight);
        driver.findElement(calculateBtn).click();
    }
    public String getResult(){
        return driver.findElement(resultLbl).getText();
    }
}