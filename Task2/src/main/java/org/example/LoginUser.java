package org.example;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class LoginUser {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-login")).click();

        driver.findElement(By.id("Email")).sendKeys("7270JohnWick1234@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Wick1234");

        driver.findElement(By.cssSelector("input.button-1[type='submit'][value='Log in']")).click();

//Checking if user is logged in. (customer account is avalible )
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement customerAccount = wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("account"))));

        String loggedUserMail = customerAccount.getText();
        Assert.assertEquals(loggedUserMail, "7270JohnWick1234@gmail.com");

        driver.quit();

    }
}
