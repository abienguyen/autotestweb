package specs.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
    }
}
