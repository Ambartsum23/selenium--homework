import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AutoComplere {
    public WebDriver driver;
    @BeforeMethod
    public void bef() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void acomplere(){
        driver.get("https://www.google.com/");
        WebElement textinput= driver.switchTo().activeElement();
        textinput.click();
        // Type Automation in search box
        textinput.sendKeys("Automation");;

        // Put all the suggestions in the list
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".G43f7e li")));
        List<WebElement> webElements=driver.findElements(By.cssSelector(".G43f7e li"));
        //Click on last suggestion
        WebElement lastsuggestion= webElements.get(webElements.size()-1);
        lastsuggestion.click();

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
      //  new WebDriverWait(driver, 20);
      //  driver.close();
    }
}
