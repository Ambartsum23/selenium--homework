
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class CrossBrowserTest {

        WebDriver driver;

        @BeforeTest
        @Parameters("browser")

        public void setup(@NotNull String browser) throws Exception {
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                 WebDriverManager.chromedriver().setup();
                 driver= new ChromeDriver();
                driver = new HtmlUnitDriver();


            }
            else if(browser.equalsIgnoreCase("Edge")){
                //set path to Edge.exe
                System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\MicrosoftWebDriver.exe");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else{

                throw new Exception("Browser is incorrect");
            }

        }

        @Test
        public void Table() {
            driver.get("http://techcanvass.com/Examples/webtable.html");
            driver.manage().window().maximize();

            for(int rowno=1;rowno<=4;rowno++)
            {
                for(int colno=1;colno<=3;colno++)
                {
                    System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[" + rowno + "]/td[" + colno + "]")).getText());
                }
            }
        }
    }
