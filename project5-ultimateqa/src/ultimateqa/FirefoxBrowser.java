package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowser {
    public static void main(String[] args) {

        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";

        //setting up web driver for firefox browser
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //oepnong url + adusting window to max + providing implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements for email + password field element and providing value to it
        WebElement userEmailField = driver.findElement(By.id("user[email]"));
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        userEmailField.sendKeys("aman.deep@email.india");
        passwordField.sendKeys("SecretPass#123");

        //printing page source + title + current url
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();
    }
}
