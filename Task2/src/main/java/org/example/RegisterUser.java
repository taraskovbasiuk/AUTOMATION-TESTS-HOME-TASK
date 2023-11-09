package org.example;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class RegisterUser {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();


        driver.findElement(By.className("ico-register")).click();

        driver.findElement(By.id("gender-female")).click();

        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Wick");

        //generate the random email
        String domain = "gmail.com";
        String secondPart = "JohnWick1234@gmail.com";

        Random random = new Random();
        int firstRandomPart = random.nextInt(9999);
        String generatedRandomEmail = Integer.toString(firstRandomPart) + secondPart;

        driver.findElement(By.id("Email")).sendKeys(generatedRandomEmail); //how to add random meil

        //set password
        driver.findElement(By.id("Password")).sendKeys("Wick1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Wick1234");

        driver.findElement(By.id("register-button")).click();

        //check if user registered

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("result"))));

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Your registration completed");

        driver.quit();
    }
}
