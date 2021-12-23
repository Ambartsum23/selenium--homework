import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.*;

public class FileUploadTest {
    public WebDriver driver;

    @BeforeMethod
    public void bef()throws AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void upload() throws AWTException {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload ");

        //Upload file
        WebElement selectfile = driver.findElement(By.id("file-upload"));
        selectfile.sendKeys("C:\\Users\\hamba\\OneDrive\\Desktop\\Car-Logo-Designs.jpg");
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        //Try to invoke StaleElementReferenceException exception
        WebElement Date = driver.findElement(By.id("datepicker"));

        try {
            upload.click();
        }catch (StaleElementReferenceException exception){
            System.out.println("Stale element");

        }

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}
