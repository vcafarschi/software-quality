package quality.assurance.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions_Lab7 {

    static WebDriver driver;

    static WebDriverWait w;

    String actualHeaders = "";

    WebElement p;

    @Given("set up")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\elgrosu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        w = new WebDriverWait(driver, 5);
    }

    @When("I access {string}")
    public void iAccess(String url) {
        driver.get(url);
    }

    @When("I send request")
    public void iSendRequest() {
        actualHeaders = driver.getTitle();
    }

    @Then("Verify {string} opens")
    public void verifyIsOpening(String page) {
        present(actualHeaders, page);
        driver.close();
    }

    public void present(String actualHeaders, String expectedHeader) {
        if (actualHeaders.contains(expectedHeader)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }

    @When("I search for {string}")
    public void iSearchFor(String key) {
        p = driver.findElement(By.name("q"));
        p.sendKeys(key);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();
    }

    @Then("Check search result page {string} open")
    public void checkPageIsOpening(String condition) {
        if (condition.equals("is") && !actualHeaders.equals("https://www.google.com/")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @When("open the search engine page")
    public void openTheSearchEnginePage() {
        driver.get("https://www.google.com/");
    }

    @Then("Check {string} search result")
    public void checkSearchResultNumber(String condition) {
        if (condition.equals("not empty")) {
            p = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
            String result = p.getText();
            if (result.contains("Aproximativ ")) {
                System.out.println("Test Passed!");
            }
        } else {
            p = driver.findElement(By.xpath("//*[@id=\"topstuff\"]/div/div"));
            String result = p.getText();
            if (result.contains("nu a returnat niciun document.")) {
                System.out.println("Test Passed!");
            }
        }
    }
}
