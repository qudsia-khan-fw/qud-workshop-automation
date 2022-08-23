import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class qudTest1 {

    public String baseUrl = "https://orswebsitedev.azurewebsites.net/ors";
    public WebDriver driver;

    @BeforeTest
    public void baseUrl(){
        //Use the setProperty Java method to set the chrome driver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test //there is NO main method, as testNG will drive the program execution flow.
   public void loginTest(){
        //Enter email address
        driver.findElement(By.name("email")).sendKeys("barfi@gmail.com");
        //Enter password
        driver.findElement(By.name("password")).sendKeys("Fresh123");
        //Click on Submit to log in
        driver.findElement(By.name("submit")).click();
    }

    @AfterTest
    public void endSession(){
        driver.close();
    }

}


