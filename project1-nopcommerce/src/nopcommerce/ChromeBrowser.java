package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {

    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //setting up web driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //launches the URL
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //we give implicit time to driver means wait until my page load completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //getting the title of the webpage
        String title = driver.getTitle();
        System.out.println("Page Title is : " + title);

        //getting the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is : " + currentUrl);

        //getting the page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the element email field element and stored in webelement as webelement is return type
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("test123@gmail.com");

        //find thd element password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Test123");

        //closing the browser
        driver.quit(); // you can use close() as well

    }
}
