package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowser {
    public static void main(String[] args) {
        String baseUrl = "https://www.saucedemo.com/";

        //setting up the webdriver
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //opening url + adjusting window to max + providing inplicit time
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //finding elemets for username + password and aapending value to it
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        //printing page source + title + current URL
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page Current URL is: " + driver.getCurrentUrl());

        //quitting browser
        //driver.quit();

    }
}
