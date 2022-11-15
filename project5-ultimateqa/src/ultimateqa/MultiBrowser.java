package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    //setting up global static variable for browser + url + webdriver
    static String browser = "edge";
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {

        //setting up webdrivers for browsers in test
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.out.println("Invalid browser name");
        }
        //opening url + adjusting window size to max + providing implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements for user email and password field and providing value to it
        WebElement userEmailField = driver.findElement(By.id("user[email]"));
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        userEmailField.sendKeys("homeowrk@prime.com");
        passwordField.sendKeys("finaltyping");

        //printing page source + title + current url
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();

    }
}
