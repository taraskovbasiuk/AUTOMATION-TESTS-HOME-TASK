package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertNotEquals;


public class CheckSearch  {
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.search-icon.dark-iconheader-search__search-icon"))).click();

        WebElement searchField = driver.findElement(By.id("new_form_search"));
        searchField.sendKeys("AI");
        searchField.sendKeys(Keys.RETURN);

        WebElement searchText = driver.findElement(By.className("search-results__counter"));
        String actualResultText = searchText.getText();


        //find results number and compare with "0"
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(actualResultText);

        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            assertNotEquals(number, 0);

        }
    }
}