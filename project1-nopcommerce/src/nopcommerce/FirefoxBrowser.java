package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowser {
    public static void main(String[] args){

        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //setting up the webdriver and class
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //launching the url
        driver.get(baseUrl);
        //maximizing windows
        driver.manage().window().maximize();
        //we give driver a implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        //getting the title of the web page
        String title = driver.getTitle();
        System.out.println("Title of the page : " + title);
        //getting the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //getting page source
        System.out.println("Page source : " + driver.getPageSource());
        //find the element for email and enter email id in field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("test445@gmail.com");
        //find the element for password and enter password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Test456");

        //closing browser
        driver.quit();




    }
}
