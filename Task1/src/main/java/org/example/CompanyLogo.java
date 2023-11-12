package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyLogo {


    public static void task8(WebDriver driver)  {


        driver.get("https://www.epam.com/about");
        driver.manage().window().maximize();

        //accept cookies
        /*driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement ourLocations = driver.findElement(By.xpath("//button[@id = 'onetrust-accept-btn-handler']"));*/


        //company logo
        WebElement logo = driver.findElement(By.xpath("(//img[@class=\"header__logo header__logo-light\"])[1]"));
        logo.click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://www.epam.com/");

    }
}
