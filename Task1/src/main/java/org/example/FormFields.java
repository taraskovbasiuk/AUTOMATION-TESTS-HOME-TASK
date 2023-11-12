package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormFields {

    public static void task7(WebDriver driver)  {

        driver.get("https://www.epam.com/about/who-we-are/contact");
        driver.manage().window().maximize();

        //accept cookies
        /*driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement ourLocations = driver.findElement(By.xpath("//button[@id = 'onetrust-accept-btn-handler']"));*/


        //scroll to element

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement AskUs = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div[3]/div[5]/div/p/span/span"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", AskUs);

        //put the cursor on the all required fields one by one

        WebElement nameField = driver.findElement(By.xpath("//input[contains(@id, \"user_first_name\")]"));
        nameField.click();

        WebElement lastNameField = driver.findElement(By.xpath("//input[contains(@id, \"user_last_name\")]"));
        lastNameField.click();

        WebElement emailField = driver.findElement(By.xpath("//input[contains(@id, \"user_email\")]"));
        emailField.click();

        WebElement phoneField = driver.findElement(By.xpath("//input[contains(@id, \"user_phone\")]"));
        phoneField.click();

        driver.findElement(By.xpath("//input[contains(@id, \"user_company\")]")).click();


        //hover over required fields one py one and check required tooltip
        Actions action = new Actions(driver);

        action.moveToElement(nameField).perform();
        WebElement nameError = driver.findElement(By.xpath("//span[contains(@id, 'user_first_name-error')]"));
        String itemName = nameError.getText();
        Assert.assertEquals(itemName, "This is a required field");


        action.moveToElement(lastNameField).perform();
        WebElement lastNameError = driver.findElement(By.xpath("//span[contains(@id, 'user_last_name-error')]"));
        String itemLastName = lastNameError.getText();
        Assert.assertEquals(itemLastName, "This is a required field");


        action.moveToElement(emailField).perform();
        WebElement emailError = driver.findElement(By.xpath("//span[contains(@id, 'user_email-error')]"));
        String itemEmail = emailError.getText();
        Assert.assertEquals(itemEmail, "This is a required field");


        action.moveToElement(phoneField).perform();
        WebElement phoneError = driver.findElement(By.xpath("//span[contains(@id, 'user_phone-error')]"));
        String itemPhone = phoneError.getText();
        Assert.assertEquals(itemPhone, "This is a required field");

        }
    }

