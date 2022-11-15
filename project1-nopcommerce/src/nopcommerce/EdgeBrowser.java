package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //setting up webdriver
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        //launching url
        driver.get(baseUrl);
        //maximizing windows
        driver.manage().window().maximize();
        //we give implicit time to dirver to wait until complete page loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //getting of title of the web page
        String title = driver.getTitle();
        System.out.println("Page Title is : " + title);
        //getting the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //getting page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source is : " + pageSource);
        //find element for email and entering email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("test789@gmail.com");
        //find element for password and entering password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Test789");

        //closing browser
        driver.quit();



    }

}
