package quality.assurance.com;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class IntroductionToAutomation_Lab5
{
    WebDriver driver;
    String actualHeaders = "";
    WebElement p;
    WebDriverWait w;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\elgrosu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        actualHeaders = "";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        w = new WebDriverWait(driver, 5);
    }

    @After
    public void setoff(){
        driver.close();
    }
    @Test
    public void testGoogle()
    {
        //Open google.com. Search for computer. Check if google header is displayed
        driver.get("https://www.google.com/");
        p=driver.findElement(By.name("q"));
        p.sendKeys("Computer");
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"Google");
    }

    @Test
    public void testYoutube()
    {
        //Open youtube.com. Search for computer. Check if google header is displayed
        driver.get("https://www.youtube.com/");
        p=driver.findElement(By.name("search_query"));
        p.sendKeys("Computer");
        driver.findElement(By.id("search-icon-legacy")).click();
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"Youtube");
    }

    @Test
    public void testAmazon()
    {
        //Open amazon.com. Search for computer. Check if google header is displayed
        driver.get("https://www.amazon.com/");
        p=driver.findElement(By.id("twotabsearchtextbox"));
        p.sendKeys("Computer");
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"Amazon");
    }

    @Test
    public void testEbay()
    {
        //Open ebay.com. Search for computer. Check if google header is displayed
        driver.get("https://www.ebay.com/");
        p=driver.findElement(By.id("gh-ac"));
        p.sendKeys("Computer");
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"Ebay");
    }

    @Test
    public void testAliexpress()
    {
        //Open aliexpress.com. Search for computer. Check if google header is displayed
        driver.get("https://www.aliexpress.com/");
        p=driver.findElement(By.name("SearchText"));
        p.sendKeys("Computer");
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"AliExpress");
    }

    @Test
    public void test999()
    {
        //Open 999.md. Search for computer. Check if google header is displayed
        driver.get("https://www.999.md/");
        p=driver.findElement(By.name("query"));
        p.sendKeys("Computer");
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
        actualHeaders= driver.getTitle();
        present(actualHeaders,"999");
    }

    public void present(String actualHeaders, String expectedHeader){
        if (actualHeaders.contains(expectedHeader)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }
}