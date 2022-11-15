package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {
public static void main(String[] args){
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    //setting up webdriver
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    //launching url
    driver.get(baseUrl);
    //maximizing window
    driver.manage().window().maximize();
    //giving browser a implicit time to wait until it loads completly
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //printing title of page + current URL + Page source
    System.out.println("Page title is: " + driver.getTitle());
    System.out.println("Current URL is: " + driver.getCurrentUrl());
    System.out.println("Page source is: " + driver.getPageSource());

    //entering email id and password
    WebElement emailField = driver.findElement(By.name("username"));
    emailField.sendKeys("Admin");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("admin123");

    //closing browser
    //driver.quit();



}
}
