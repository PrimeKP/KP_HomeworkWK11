package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {
    public static void main(String[] args) {
        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";

        //setting up webdeiver for edge browser
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //opeining url + window size to max + providing implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements for user email + password and providing value to it
        WebElement userEmailField = driver.findElement(By.id("user[email]"));
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        userEmailField.sendKeys("farm.land@agrigo.com");
        passwordField.sendKeys("myProduct#22");

        //printing page source + title + url
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();
    }
}
