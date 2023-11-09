package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutItem {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().window().maximize();

        //user login
        driver.findElement(By.className("ico-login")).click();

        driver.findElement(By.id("Email")).sendKeys("7270JohnWick1234@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Wick1234");
        driver.findElement(By.cssSelector("input.button-1[type='submit'][value='Log in']")).click();

        //adding item to the cart
        driver.findElement(By.cssSelector("a[href='/books']")).click();
        driver.findElement(By.xpath("(//div[@class = 'add-info']/child::div)[2]/input[1]")).click();
        driver.findElement(By.className("ico-cart")).click();

        //accept terms of service
        driver.findElement(By.id("termsofservice")).click();

        //checkout button
        driver.findElement(By.id("checkout")).click();

        //Checkout process
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement continueShippingAdr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")));
        continueShippingAdr.click();

        WebElement continueShippingMeth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")));
        continueShippingMeth.click();

        WebElement continuePaymentMeth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")));
        continuePaymentMeth.click();

        WebElement continuePaymentInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")));
        continuePaymentInfo.click();




        //Confirmation
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")));
        confirmation.click();
        //driver.findElement(By.className("button-1 confirm-order-next-step-button")).click();


        // Check that order successfully processed

        WebElement finishOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"page-body checkout-data\"]/div/div[1]")));
        String success = finishOrder.getText();
        Assert.assertEquals("Your order has been successfully processed!", success);
    }
}
