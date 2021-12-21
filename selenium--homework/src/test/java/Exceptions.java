import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Exceptions{
    public WebDriver driver;

    @BeforeMethod
    public void bef() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void handleExceptions() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        WebElement Date = driver.findElement(By.id("datepicker"));
        Date.click();
        driver.findElement(By.className("ui-datepicker-prev")).click();
        WebElement dates = driver.findElement(new By.ByXPath("//*[@id='ui-datepicker-div']/table/tbody/tr[last()]//td[@data-handler='selectDay'][last()]"));
        dates.click();
        // driver.switchTo().defaultContent();

        //new WebDriverWait(driver, 3).Until(ExpectedConditions.frameToBeAvaliableAndSwitchToIt(1));
        try {
            driver.switchTo().frame(0);
        } catch (NoSuchFrameException  A) {
            System.out.println("exception handled ");
        }
    }
    @Test
    public void testException(){
        driver.get("https://demoqa.com/alerts ");
        WebElement clickme = driver.findElement(By.id("timerAlertButton"));
        clickme.click();
      //- Try to invoke StaleElementReferenceException
        WebElement Date = driver.findElement(By.id("datepicker"));
        driver.switchTo().defaultContent();
        Date.click();
        // Try to invoke TimeOutException exception
        new WebDriverWait(driver,2).until(ExpectedConditions.alertIsPresent());

        try {
            driver.switchTo().alert().accept();
        }
        catch(NoAlertPresentException A){
            System.out.println("alert is not found");
            System.out.println(A.getMessage());
        }
        catch(TimeoutException A){
            System.out.println(A.getMessage());
            System.out.println("alert will appear after 5 second");
        }
        catch (StaleElementReferenceException A){
            System.out.println("alert is not found");
        }
        System.out.println("exit block");
    }

    @AfterMethod(alwaysRun = true)
    public void closebrowser(){
        // driver.quit();
    }
}
