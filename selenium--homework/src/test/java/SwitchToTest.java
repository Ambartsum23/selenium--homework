import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToTest {
    public WebDriver driver;

    @BeforeMethod
    public void bef() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void frame() {
        driver.navigate().to("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.id("tinymce"));
        System.out.println("firs text in frame : " + text.getText());
        text.clear();
        text.sendKeys(" Here Goes");
        System.out.println("The text wich we write in frame : " + text.getText());
        driver.switchTo().defaultContent();
        WebElement center = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]"));
        center.click();
        driver.switchTo().defaultContent();

    }

    @Test
    public void alertClick()  {
        driver.get("https://demoqa.com/alerts");
       WebElement ok = driver.findElement(By.id("alertButton"));
        Alert OK = driver.switchTo().alert();
        //System.out.println("Tex in the alert : " + OK.getText());
        driver.switchTo().alert().accept();



    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        new WebDriverWait(driver, 15);
      //driver.quit();
    }
}

