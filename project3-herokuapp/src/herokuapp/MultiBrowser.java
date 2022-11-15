package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    //setting static global variables for Browser + Base URL + Driver

    static String browser = "edge";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {

        //setting up the webdriver for all browser we are testing
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.deriver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.out.println("Incorrect browser name");
        }
        //launching url + adjusting window to max + providing browser a implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements of email and password and entering values
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        //printing page source + title + current url
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();
    }

}
