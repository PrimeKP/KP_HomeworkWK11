package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args) {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //setting up webdrivers
        System.setProperty("driver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //opening url + adjusting windows to max + providing implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding email and password elements and providing value to them
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        //printing title + current URl + page source
        System.out.println("Page Source is: " + driver.getPageSource());
        System.out.println("Page Title is: " + driver.getTitle());
        System.out.println("Page Current URL is: " + driver.getCurrentUrl());


        //quitting browser
        //driver.quit();
    }
}
