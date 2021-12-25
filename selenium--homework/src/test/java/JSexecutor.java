import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;

public class JSexecutor {
    WebDriver driver;
    Actions actions;
   JavascriptExecutor js;
   ChromeOptions options;

    @BeforeMethod
    public void bef() throws AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
        actions=new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();}

        @Test
        public void js(){

            driver.get(" http://webdriveruniversity.com/To-Do-List/index.html ");;
            List<WebElement>toDoList = driver.findElements(By.cssSelector("ul li"));
            WebElement toDo = toDoList.get(toDoList.size()-1);
            actions.moveToElement(toDo).perform();
            List<WebElement> Deletelist = driver.findElements(By.cssSelector("li i"));
            WebElement Delete = Deletelist.get(Deletelist.size()-1);
            js.executeScript("arguments[0].click()", Delete);

            }

        @Test
         public void doScroll() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement element =driver.findElement(By.id("zone2-entries"));
       Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();",element);
        String entriestext = js.executeScript("return document.getElementById('zone2').textContent").toString();
        System.out.println(entriestext);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        //driver.quit();
       }
    }



