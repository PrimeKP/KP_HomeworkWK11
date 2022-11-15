package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://www.saucedemo.com/";

        //setting up the browser
        System.setProperty("webdriver.edge.drier", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //opening page + adjusting window to max + providing implicit time to browser
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elements for username and password and providing value to them
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        //printing page source + page title + current url
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();

    }
}