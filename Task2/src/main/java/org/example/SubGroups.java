package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SubGroups {
    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("(//a[@href='/computers'])[1]")).click();

        List<WebElement> elements = driver.findElements(By.className("sub-category-item"));
        int elementsCount = elements.size();
        Assert.assertEquals(elementsCount, 3);

        //check the elements names one by one

        WebElement Name1 = driver.findElement(By.xpath("(//a[@href='/desktops'])[4]"));
        String subGroup1 =Name1.getText();
        Assert.assertEquals(subGroup1, "Desktops");

        WebElement Name2 = driver.findElement(By.xpath("(//a[@href='/notebooks'])[4]"));
        String subGroup2 =Name2.getText();
        Assert.assertEquals(subGroup2, "Notebooks");

        WebElement Name3 = driver.findElement(By.xpath("(//a[@href='/accessories'])[4]"));
        String subGroup3 =Name3.getText();
        Assert.assertEquals(subGroup3, "Accessories");

        driver.quit();
    }
}
