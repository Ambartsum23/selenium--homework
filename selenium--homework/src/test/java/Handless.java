import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

class Heandless {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor js;
    ChromeOptions options;

        public void  setup() {
            WebDriverManager.chromedriver().setup();
            driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
            actions=new Actions(driver);
            js = (JavascriptExecutor) driver;
            driver.manage().window().maximize();}
        @Test
        public void DynamicTable() throws InterruptedException{
            driver= new HtmlUnitDriver();
            driver.get("http://techcanvass.com/Examples/webtable.html");
            driver.manage().window().maximize();
            //statikurad ro  davbejdot
            //  System.out.println( driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[4]/td[3]")).getText());}

            // dinamiurad bejdvitvis shegvidzliat tablshi gaviarot ciklit
            for (int i = 1; i <=4; i++) {
                for (int s = 1; s < 4; s++) {
                    System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr["+i+"]/td["+s+"]")).getText());
                }
            }
        }
    @Test
    public void upload() {
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
        public void closebrowser() {
            //driver.close();
        }
    }

