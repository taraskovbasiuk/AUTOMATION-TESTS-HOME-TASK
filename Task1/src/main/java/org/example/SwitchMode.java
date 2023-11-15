package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;


public class SwitchMode {
    public static void task2(WebDriver driver) {

        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".theme-switcher[shub-ins='1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@class='fonts-loaded light-mode']")));
        String lightTheme = driver.findElement(By.xpath("/html/body")).getAttribute("class");

        Assert.assertEquals(lightTheme, "fonts-loaded light-mode");

        driver.findElement(By.xpath("(//div[@class='theme-switcher'])[2]")).click();


        WebElement DTheme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@class='fonts-loaded dark-mode']")));
        String darkTheme = DTheme.getAttribute("class");

        Assert.assertEquals(darkTheme, "fonts-loaded dark-mode");

    }
}