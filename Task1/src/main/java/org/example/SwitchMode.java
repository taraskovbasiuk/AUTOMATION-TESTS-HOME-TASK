package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;


public class SwitchMode {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='theme-switcher'])[2]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body")));
        String lightTheme = driver.findElement(By.xpath("/html/body")).getAttribute("class");
        Assert.assertEquals(lightTheme, "fonts-loaded light-mode");

        driver.findElement(By.xpath("(//div[@class='theme-switcher'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body")));
        String darkTheme = driver.findElement(By.xpath("/html/body")).getAttribute("class");
        Assert.assertEquals(darkTheme, "fonts-loaded dark-mode");
    }
}