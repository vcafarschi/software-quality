package quality.assurance.com;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions_Lab6 {
    static WebDriver driver;
    static WebDriverWait w;
    String homePage= "https://loving-hermann-e2094b.netlify.app/contact.html";
    String homePageTitle= "";
    WebElement webElement;
    static HashMap map;

    @Given("Open home page")
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\elgrosu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        w = new WebDriverWait(driver, 5);
        map=new HashMap<String , String>();
        map.put("Name","/html/body/div[9]/div/div/div[1]/div[2]/form/div[1]/input");
        map.put("Email","/html/body/div[9]/div/div/div[1]/div[2]/form/div[2]/input");
        map.put("Subject","/html/body/div[9]/div/div/div[1]/div[2]/form/div[3]/input");
        map.put("Message","/html/body/div[9]/div/div/div[1]/div[2]/form/div[4]/textarea");
        driver.get(homePage);
        homePageTitle=driver.getTitle();
    }

    @When("I introduce {string} value {string}")
    public void iIntroduceValue(String inputXPath, String value) {
        webElement = driver.findElement(By.xpath(String.valueOf(map.get(inputXPath))));
        webElement.click();
        webElement.sendKeys(value);
        webElement.isDisplayed();
    }

    @When("I submit form")
    public void iSubmitForm() {
        //submit Sign Up Form
        WebElement submit = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/input"));
        submit.click();
    }

    @Then("Redirect Page")
    public void redirectPage() {
        // Assertion
        String actualPage= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals(homePage, actualPage);
        Assert.assertNotEquals(homePageTitle, actualTitle);
        driver.close();
    }

    @Then("Get Validation Error")
    public void getValidationError() {
        // Assertion
        String actualPage= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();
        Assert.assertEquals(homePage, actualPage);
        Assert.assertEquals(homePageTitle, actualTitle);
        driver.close();
    }
}