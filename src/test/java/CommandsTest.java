import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class CommandsTest {
    @Test
    public void test() {
        WebDriverManager driverManager = new ChromeDriverManager();
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("http://google.com");

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.id("//*[@id=\"input-example\"]/button"));
        button.click();
        // boolean value = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).isEnabled();
        //  System.out.println("isEnabled " + button.isEnabled());

        System.out.println( driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).getText());


        if (driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).getText()=="Disable")
        {
            System.out.println("isEnabled " + button.isEnabled());
        }else {
            System.out.println("isDisabled ");
        }

        WebElement bootcamp = driver.findElement(By.id("input-example"));
        bootcamp.sendKeys("Bootcamp");
        bootcamp.submit();
        driver.quit();
    }
    @Test
    public void cordinate(){
        WebDriverManager driverManager = new ChromeDriverManager();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");


        int point_a = driver.findElement(By.id("collumn-a")).getLocation().getY();
        int point_b = driver.findElement(By.id("collumn-b")).getLocation().getY();
        if (point_a == point_b) {
            System.out.println("collum A`s snd collum B`s coedinats is equal " + point_a + " = " + point_b);
        }
    }
}