
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitsTest {
public WebDriver driver;

    @BeforeMethod
public void bef(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();

}
    @Test

    public void test3() {

       // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver.navigate().to("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.id("startStopButton"));
        button.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='100%']")));
        System.out.println(driver.findElement(By.xpath("//div[text()='100%']")).getText());

    }
    @AfterMethod(alwaysRun = true)
    public void lasttest(){
    new WebDriverWait(driver, 15);
    driver.quit();

    }
}

