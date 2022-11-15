package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {
    public static void main(String[] args) {

        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";

        //setting up driver from chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //opening url + adjusting window to max + providing implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements for username and password and providing value to it
        WebElement emailField = driver.findElement(By.id("user[email]"));
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        emailField.sendKeys("xyz.abc@gmail.com");
        passwordField.sendKeys("Abcxyz123");

        //printing page source + title + current URL
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();


    }
}
