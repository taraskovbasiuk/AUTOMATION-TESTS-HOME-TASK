package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

import org.junit.*;


public class ChangeLanguage {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("location-selector__button"))).click();

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a")).click();


        WebElement htmlTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));


        String lang = htmlTag.getAttribute("lang");

        sleep(2000);

        Assert.assertEquals(lang, "uk-UA");


    }
}