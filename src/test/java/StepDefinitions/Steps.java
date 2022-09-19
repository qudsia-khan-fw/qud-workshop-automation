package StepDefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Steps {
    public String baseUrl = "https://orswebsitedev.azurewebsites.net/ors";
    public String homeUrl = "https://orswebsitedev.azurewebsites.net/";
    public String createReviewUrl = "https://orswebsitedev.azurewebsites.net/ors/create-item/Review";
    public WebDriver driver;


    @Given("the user is on the login page")
        public void login_page() {
            //Use the setProperty Java method to set the chrome driver path
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
            driver.get(baseUrl);
        }

        @When("the user enters a valid {string} and a valid {string}")
            public void enter_credentials(String email, String password) {
                driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("password")).sendKeys(password);
            }

        @And("clicks on submit")
            public void clicks_on_submit() throws InterruptedException {

                //Click on Submit to log in
                driver.findElement(By.name("submit")).click();
                //page load wait
                TimeUnit.SECONDS.sleep(5);
             }

        @Then("the user should be successfully logged in to the app")
            public void user_logged_in() {
                System.out.println(driver.getCurrentUrl());
                if (driver.getCurrentUrl().equalsIgnoreCase(homeUrl)) {
                    System.out.println("I have successfully logged in to the ORS web app");
                } else {
                    Assert.assertTrue(driver.getPageSource().contains("The username or password you entered is incorrect"),
                            "Invalid credentials error message not found");

                    driver.quit();
                }
             }

    @Given ("the user logs in with email {string} and password {string}")
        public void user_logs_in(String email, String password) throws InterruptedException {
            login_page();
            enter_credentials(email, password);
            clicks_on_submit();
            if (driver.getCurrentUrl().equalsIgnoreCase(homeUrl)) {
                System.out.println("I am on the homepage");
            } else {
                Assert.assertTrue(driver.getPageSource().contains("Welcome to the ORS"),
                        "homepage description not found");
            }
        }
        @When("the user lands on the create review page")
            public void clicks_reviews_button() throws InterruptedException {
                driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiButton-label")).click();
                TimeUnit.SECONDS.sleep(5);
                driver.findElement(By.cssSelector(".MuiButton-containedPrimary > .MuiButton-label")).click();
                driver.findElement(By.cssSelector(".MuiListItem-root:nth-child(1)")).click();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(driver.getCurrentUrl());
                if (driver.getCurrentUrl().equalsIgnoreCase(createReviewUrl)) {
                    System.out.println("I am on the create review page");
                } else {
                    Assert.assertTrue(driver.getPageSource().contains("Create New Review Item"),
                            "not on create review screen");
                }
        }
        @And("fills in the required form fields")
               public void fill_required_fields()  throws InterruptedException {
                    driver.findElement(By.name("name")).sendKeys("qudAutomation");
                    driver.findElement(By.name("title")).sendKeys("myAutomationProject");
                    driver.findElement(By.name("fileNumber")).sendKeys("EA2021-01");
                    driver.findElement(By.name("title")).click();
                    TimeUnit.SECONDS.sleep(5);
                    WebElement option = driver.findElement(By.id("mui-component-select-activityId"));
                    option.click();
                    option.findElement(By.xpath("//div[@id='menu-activityId']/div[3]/ul/li[9]")).click();
                    option = driver.findElement(By.id("mui-component-select-boardId"));
                    option.click();
                    option.findElement(By.xpath("//div[@id='menu-boardId']/div[3]/ul/li[2]")).click();




        }
        @And("publishes the review")
                public void publish_review() {

        }
        @Then("the review should be published")
                public void review_is_published() {

        }

        @And("the user should be navigated to the review detail page")
                public void see_review_details() {

        }

    }


