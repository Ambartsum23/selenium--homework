import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest {
    public WebDriver driver;
    @BeforeMethod
    public void bef() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void handleDynamicTable() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        //statikurad ro  davbejdot
      //  System.out.println( driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[4]/td[3]")).getText());}

        // dinamiurad bejdvitvis shegvidzliat tablshi gaviarot ciklit
       for (int i = 4; i <5; i++) {
            for (int s = 3; s < 4; s++) {
                System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr["+i+"]/td["+s+"]")).getText());
            }
        }
    }
    @AfterMethod(alwaysRun = true)
    public void closebrowser() {

    driver.close();
    }
}

