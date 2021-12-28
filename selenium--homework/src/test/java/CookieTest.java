import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Set;
import java.awt.*;

public class CookieTest {
    WebDriver driver;
    @BeforeMethod
    public void bef()throws AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void cookitest() throws InterruptedException {
       driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        //Sign in the system and save cookies

        driver.findElement(By.name("username")).sendKeys("mngr377625");
        driver.findElement(By.name("password")).sendKeys("zAhYmYz");
        driver.findElement(By.name("submit")).click();
       Set<Cookie> cookies = driver.manage().getCookies();
       //List<Cookie> cookies1= driver.manage().getCookies();
        for(Cookie cooki:cookies) {
                driver.manage().deleteCookieNamed("Selenium");
                if (cooki.getExpiry()==null)
                {
                    driver.manage().deleteCookie(cooki);
                }
        }
    }
}
