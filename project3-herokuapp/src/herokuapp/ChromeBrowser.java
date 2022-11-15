package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {

    public static void main(String[] args) {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //setting up webdriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //launching URL + adjusting window to maximum + providing implicit timeour
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //printing title + Current URL + page source
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());
        System.out.println("Page source is: " + driver.getPageSource());

        //entering email and password after locating their field
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        //Quitting browser
        //driver.close();
    }
}
