package specs.theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest {
    /**
     * Login successful with valid credentials
     *     //1.Open browser
     *     //2.Navigate to https://the-internet.herokuapp.com/login
     *     //3.Fill in username with tomsmith
     *     {
     *         tagName: input,
     *         attributes: [{
     *             key: type,
     *             value: text <> generic meaning << remove khỏi danh sách thuộc tính mình lấy ban đầu
     *         },
     *         {
     *         key: name,
     *         value: username
     *         },
     *         {
     *             key: id,
     *             value: username
     *         }
     *         ],
     *         text (content): N/A
     *     }
     *
     *
     *     //4.Fill in the password with SuperSecretPassword!
     *     {
     *         tagName: input,
     *         Attributes:[
     *         {
     *         key: type,
     *         value: password,
     *         },
     *         {
     *             key: name,
     *             value: password
     *         },
     *         {
     *             key: id,
     *             value: password
     *         }
     *
     * }]
     *     }
     *     //5.Click on Login button
     *     {
     *         tagName: button,
     *         Attributes:[
     *         {
     *             key: type
     *             value: submit
     *         }
     *         {
     *             key: class
     *             value: radius
     *         }
     *         ]
     *     }
     *     //6.And the home page is appear
     */

    /** Thứ tự ưu tiên để lấy Locator
     * 1.Get All element properties
     * 2.Remove Attributes which have value is generic (remove attribute có nghĩa chung chung)
     * 3.Check valid locator string => check runnable  (chạy thử có đc hay ko)
     * 4. Check locator string meaning full => help to image UI element ==> nào ngắn nhất giữ lại
     * 5.Bám theo thứ tự ở dưới để lấy:
     * ID => Name => TagName => CSS => Xpath (ko dùng cách này)
     * ID => Name => ClassName => CSS => Xpath (Ưu tiên dòng nào ngắn nhất thì lấy, và ko đưa tagName vào vì dễ bị trùng)
     */

    /** Công thức viết syntax lấy Locator
     * Element {tagName: E, Attribute {key: A, value: t}}
     * Css => E[A=t] (tất cả tagName) or [A=t] (any tagName)
     * if A==id >> #t
     * if A=class >> .t
     * xpath => //E[@A='t'] (tất cả tagName) or //*[@A='t'] (any tagName) => //E[contains(@A,'t')]
     * absolute path, relative path
     */

    @Test
    void successfullyWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        // tóm tắt giữ lại cách này:
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.quit();

// Lấy theo tagName
//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");

//Lấy theo Attribute - tl câu truyền username
/*        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

 */
//Click button
        driver.findElement(By.className("radius")).click();
        driver.findElement(By.cssSelector(".radius")).click();
        driver.findElement(By.cssSelector("button.radius")).click();
        driver.findElement(By.xpath("//*[@class='radius']")).click();
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify domain
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }
    @Test
    void errorWithInvalidUsername(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        // tóm tắt giữ lại cách này:
        driver.findElement(By.id("username")).sendKeys("tomsmith123");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        String flashMessage = driver.findElement(By.className("success")).getText();
        Assert.assertTrue(flashMessage.contains("You logged in"));
        driver.quit();
    }
        @Test
        void errorWithInvalidPassword(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/login");
            // tóm tắt giữ lại cách này:
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!123");
            driver.findElement(By.cssSelector("button[type=submit]")).click();
        String flashMessage = driver.findElement(By.className("error")).getText();
        Assert.assertTrue(flashMessage.contains("Your password is invalid!"),flashMessage);
        driver.quit();
    }
}
