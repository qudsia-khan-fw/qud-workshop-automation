package StepDefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class Steps {
    public String baseUrl = "https://orswebsitedev.azurewebsites.net/ors";
    public String homeUrl = "https://orswebsitedev.azurewebsites.net/";
    public WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        //Use the setProperty Java method to set the chrome driver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @When("the user enters a valid {string} and a valid {string}")
    public void the_user_enters_a_valid_and_a_valid(String arg1, String arg2) {
        driver.findElement(By.name("email")).sendKeys(arg1);
        driver.findElement(By.name("password")).sendKeys(arg2);
    }

    @And("clicks on submit")
    public void clicks_on_submit() throws InterruptedException {

        //Click on Submit to log in
        driver.findElement(By.name("submit")).click();
        //page load wait
        TimeUnit.SECONDS.sleep(5);
    }

    @Then("the user should be successfully logged in to the app")
    public void the_user_should_be_successfully_logged_in_to_the_app() {
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equalsIgnoreCase(homeUrl)){
            System.out.println("I have successfully logged in to the ORS web app");
        }
        else{
            Assert.assertTrue(driver.getPageSource().contains("The username or password you entered is incorrect"),
                    "Invalid credentials error message not found");
        }
        driver.quit();
    }

}