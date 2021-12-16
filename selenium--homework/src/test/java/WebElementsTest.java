import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class WebElementsTest {

    //WebDriverManager driverManager = new ChromeDriverManager();
    // WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {
        WebDriverManager driverManager = new ChromeDriverManager();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver.get(" http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.cssSelector(".example button"));
        button.click();
        button.click();
        button.click();
        System.out.println(driver.findElement(By.cssSelector("#elements > button:nth-child(3)")).getText());
        //System.out.println(driver.findElements(By.cssSelector("button[class^='added']")))[button.get(button.size()-1)];
        System.out.println(driver.findElement(By.xpath("//button[contains(@class,'manualy')][last()][text()='Delete']")).getText());



    }
    @Test
    public void test2(){
        WebDriverManager driverManager = new ChromeDriverManager();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
        System.out.println(driver.findElement(By.xpath("//*[@id='content']//td[contains(text(),'Apeirian9')]//preceding-sibling::td")).getText());
        System.out.println( driver.findElement(By.xpath("//*[@id='content']//td[contains(text(),'Apeirian9')]//following::td")).getText());
    }

}