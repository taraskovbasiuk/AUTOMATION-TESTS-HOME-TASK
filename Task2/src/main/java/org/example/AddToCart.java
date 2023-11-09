package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//div[@class = 'add-info']/child::div)[2]/input[1]")).click();
        driver.findElement(By.className("ico-cart")).click();

        //check that product is placed in the cart

        WebElement item = driver.findElement(By.xpath("//*[@class = 'cart-item-row']//*[text()='Computing and Internet']"));

        String itemName = item.getText();
        Assert.assertEquals(itemName, "Computing and Internet");

        driver.quit();
    }
}
