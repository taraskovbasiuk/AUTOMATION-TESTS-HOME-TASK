package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class SwitchLocation {


        public static void task5(WebDriver driver)  {


            driver.manage().window().maximize();


            //accept the cookie


            //scroll to locations

            WebElement regions = driver.findElement(By.className("tabs-ui-23"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", regions);

            //accept the cookie
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']"))).click();

            WebElement regionsAmericas = driver.findElement(By.xpath("//a[normalize-space()='AMERICAS']"));
            String SectionAmericas = regionsAmericas.getText();
            assertEquals("AMERICAS", SectionAmericas);

            WebElement regionsEMEA = driver.findElement(By.xpath("//a[normalize-space()='EMEA']"));
            String SectionEMEA = regionsEMEA.getText();
            assertEquals("EMEA", SectionEMEA);

            WebElement regionsAPAC = driver.findElement(By.xpath("//a[normalize-space()='APAC']"));
            String SectionAPAC = regionsAPAC.getText();
            assertEquals("APAC", SectionAPAC);

            //select regions under locations
            regionsAmericas.click();

            //Check Americas locations
            WebElement ColombiaLocations = driver.findElement(By.xpath("//div[contains(text(),'Colombia')]"));
            String ColumbLocTxt = ColombiaLocations.getText();
            Assert.assertEquals(ColumbLocTxt, "2 Locations");

            driver.findElement(By.xpath("//div[contains(text(),'United States')]")).click();

            WebElement USALocations = driver.findElement(By.xpath("(//*[@class=\"locations-viewer-23__country-counter body-text-small\"])[1]"));
            String USALocTxt = USALocations.getText();

            Assert.assertEquals(USALocTxt, "9 Locations");

        }
    }
