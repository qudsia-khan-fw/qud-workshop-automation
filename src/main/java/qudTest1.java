import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class qudTest1 {
    public static void main (String[] args){
        /*Step 1: Invoke browser
         Chrome - ChromeDriver -> Selenium has released a class called ChromeDriver
         which has all the methods which will help us automate in this browser.
         We need to create an object of this class to access the methods in this class.
         chromedriver.exe -> third party library provided by Chrome to invoke Chrome browser. Selenium wants to automate
         on Chrome browser, but due to the architecture design they can not directly invoke the Chrome browser.
         Hence, this third party file will launch the Chrome browser. Selenium will talk to the chromedriver, so it is the
         middleman proxy. Selenium will look for this key value pair: webdriver.chrome.driver -> value of path.
         Chrome driver is present on this local path which is the value assigned to this key
         */
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // Java has a method setProperty to set the property on a global level


         /* There is an interface (a group of related methods with empty bodies - blueprint/contract) called WebDriver.
         The class responsibility is to implement the body for the methods declared in the interface. The class
         can also have its own internal methods as well. We will not create an object of class ChromeDriver driver = new ChromeDriver();
         because we do not need internal chrome methods and if we change the driver to firefox, then, the code to run firefox won't work if
         there is a method belonging only to the class ChromeDriver, and not WebDriver.
         If we refer our object to WebDriver, then this driver object will have knowledge only of the WebDriver methods
         implemented in ChromeDriver and other browsers. We want to access only methods of WebDriver using Chrome, for example.
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://orswebsitedev.azurewebsites.net/ors"); //xattr -d com.apple.quarantine <name-of-executable>
        driver.findElement(By.name("email")).sendKeys("barfi@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Fresh123");
        driver.findElement(By.name("submit")).click();


    }

}


