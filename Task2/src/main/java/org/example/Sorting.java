package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement sort_dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-orderby")));
        sort_dropdown.click();

        WebElement lowToHigh = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products-orderby\"]/option[4]")));
        lowToHigh.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-grid div.item-box")));

        List<WebElement> elementPricesSorted = (List<WebElement>) driver.findElements(By.cssSelector(".item-box .product-item"));
        List<WebElement> listCopy = new ArrayList<>(elementPricesSorted);

        listCopy.sort(Comparator.comparing(we -> {
            WebElement priceElement = we.findElement(By.cssSelector(".price.actual-price"));
            Double price = null;
            if(priceElement != null) {
                price = Double.parseDouble(priceElement.getText());
            }
            return price;
        }));

        Assert.assertEquals(elementPricesSorted, listCopy);


        WebElement aZ = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products-orderby\"]/option[2]")));
        aZ.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-grid div.item-box")));

        List<WebElement> elementAZSorted = (List<WebElement>) driver.findElements(By.cssSelector(".item-box .product-item"));
        List<WebElement> listAZCopy = new ArrayList<>(elementAZSorted);

        listAZCopy.sort(Comparator.comparing(we -> {
            WebElement nameElement = we.findElement(By.cssSelector(".product-title a"));
            String name = null;
            if(nameElement != null) {
                name = nameElement.getText();
            }
            return name;
        }));

        Assert.assertEquals(elementAZSorted, listAZCopy);
        
        driver.quit();
    }
}