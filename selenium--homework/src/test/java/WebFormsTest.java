
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFormsTest {
    public WebDriver driver;

    @BeforeMethod
    public void bef(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test

    public void dropdown() {

        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        //driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#dropdowm-menu-1")).click();
        List<WebElement> select = driver.findElements(By.xpath("//select[@id='dropdowm-menu-1' and @class='dropdown-menu-lists']/option"));
        System.out.println("Programming language was selected : " + select.get(1).getText());
        select.get(1).click();
    }


    @Test

    public void checkbox() {
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();
        List<WebElement> name = driver.findElements(By.xpath("//*[@id=\"checkboxes\"]/label/input"));

        for (WebElement selectedOption : name) {
            if (selectedOption.isSelected()) {
                continue;
            } else {
                selectedOption.click();
            }
        }
    }

    @Test

    public void radiobutton()  {
      driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
      driver.manage().window().maximize();
        WebElement color1 = driver.findElement(By.cssSelector("input[value='yellow']"));
            color1.click();

    }
    @Test
    public void  selectedanddesabled(){
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();
        WebElement fruit=driver.findElement(By.cssSelector("#fruit-selects option[value='orange']"));
        //System.out.println(fruit.getText());
        if (fruit.getText()=="disabled")
        {
            System.out.println("Orange is enabled " + fruit.isEnabled());
        }else {
            System.out.println("Orange is disabled ");
        }

    }



    @AfterMethod(alwaysRun = true)

    public void test(){

        driver.quit();

    }
}

