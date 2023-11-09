package org.example;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToWishlist {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/health");
        driver.manage().window().maximize();

        driver.findElement(By.id("add-to-wishlist-button-22")).click();
        driver.findElement(By.className("ico-wishlist")).click();

        WebElement item = driver.findElement(By.xpath("//*[@class = 'cart-item-row']//*[text()='Health Book']"));

        String itemName = item.getText();
        Assert.assertEquals(itemName, "Health Book");

        driver.quit();
    }
}