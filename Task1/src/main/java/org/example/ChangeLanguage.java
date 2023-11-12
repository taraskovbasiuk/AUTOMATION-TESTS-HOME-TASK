package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.*;


public class ChangeLanguage {
    public static void task3(WebDriver driver)  {

        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("location-selector__button"))).click();

        driver.findElement(By.xpath("//ul/li[6]/a[@class=\"location-selector__link\"]")).click();

        WebElement UaPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='location-selector__button']")));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://careers.epam.ua/");

        WebElement htmlTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));
        String lang = htmlTag.getAttribute("lang");

        Assert.assertEquals(lang, "uk-UA");

    }
}