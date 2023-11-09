package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ChangeItemNumber {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/apparel-shoes");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement pagesCountDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-pagesize")));
        pagesCountDropdown.click();

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products-pagesize\"]/option[1]")));
        option.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-grid div.item-box")));

        List<WebElement> elements = (List<WebElement>) driver.findElements(By.cssSelector(".item-box .product-item"));
        Assert.assertEquals(elements.size(), 4);

        pagesCountDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-pagesize")));
        pagesCountDropdown.click();

        option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products-pagesize\"]/option[2]")));
        option.click();
//
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-grid div.item-box")));

        elements = (List<WebElement>) driver.findElements(By.cssSelector(".item-box .product-item"));
        Assert.assertEquals(elements.size(), 8);
        driver.quit();
    }
}