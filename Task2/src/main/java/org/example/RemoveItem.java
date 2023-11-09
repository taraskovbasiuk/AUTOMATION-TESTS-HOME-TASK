package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveItem {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//div[@class = 'add-info']/child::div)[2]/input[1]")).click();
        driver.findElement(By.className("ico-cart")).click();

        //select the element in the cart
        driver.findElement(By.cssSelector("input[type='checkbox'][name='removefromcart']")).click();

        driver.findElement(By.name("updatecart")).click();


        WebElement emptyCart = driver.findElement(By.className("order-summary-content"));
        String emptyCartText = emptyCart.getText();
        Assert.assertEquals("Your Shopping Cart is empty!",emptyCartText);

        driver.quit();
    }
}
