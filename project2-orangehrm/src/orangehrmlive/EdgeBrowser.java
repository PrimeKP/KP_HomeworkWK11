package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        //setting up webdriver
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        //launching URL + maximizing screen + giving implicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //getting page title + current url + page source
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());
        System.out.println("Page source is: " + driver.getPageSource());

        //entering email and password
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //closing browser
        //driver.quit();
    }

}
