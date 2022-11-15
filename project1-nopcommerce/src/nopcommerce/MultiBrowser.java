package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

//defining static variable
    static String browser = "chrome";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {

        //setting up web drivers for the multiple browsers
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else{
            System.out.println("Incorrect browser name");
        }
        //now launching the URL
        driver.get(baseUrl);
        //now maximizing window
        driver.manage().window().maximize();
        //now we give implicit time to driver to wait until everything
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //printing title of webpage
        System.out.println("Page title is: " + driver.getTitle());
        //printing the current url
        System.out.println("Current URL is: " + driver.getCurrentUrl());
        //printing the page source
        System.out.println("Page source: " + driver.getPageSource());

        //entering email id and password
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("test123@nopcom.com");
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Test123");

        //closing browser
        //driver.quit();

    }



}
