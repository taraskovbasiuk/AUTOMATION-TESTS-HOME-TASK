
package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class CheckPolicies {

        public static void task4(WebDriver driver)  {

            driver.get("https://www.epam.com/");
            driver.manage().window().maximize();


            //scroll to locations

            WebElement policies = driver.findElement(By.xpath("//div[@class='policies-links-wrapper']"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", policies);

            WebElement investors = driver.findElement(By.xpath("//a[normalize-space()='INVESTORS']"));
            String investorsName = investors.getText();
            assertEquals("INVESTORS", investorsName);

            WebElement openSorce = driver.findElement(By.xpath("//a[normalize-space()='OPEN SOURCE']"));
            String openSorceName = openSorce.getText();
            assertEquals("OPEN SOURCE", openSorceName);

            WebElement privacyPolicy = driver.findElement(By.xpath("//a[normalize-space()='PRIVACY POLICY']"));
            String privacyPolicyName = privacyPolicy.getText();
            assertEquals("PRIVACY POLICY", privacyPolicyName);

            WebElement cookiePolicy = driver.findElement(By.xpath("//a[normalize-space()='PRIVACY POLICY']"));
            String cookiePolicyName = cookiePolicy.getText();
            assertEquals("COOKIE POLICY", cookiePolicyName);

            WebElement applicantPrivacyNotoce = driver.findElement(By.xpath("//a[normalize-space()='APPLICANT PRIVACY NOTICE']"));
            String applicantPrivacyNotoceName = applicantPrivacyNotoce.getText();
            assertEquals("APPLICANT PRIVACY NOTICE", applicantPrivacyNotoceName);

            WebElement webAccesability = driver.findElement(By.xpath("//a[normalize-space()='WEB ACCESSIBILITY']"));
            String webAccesabilityName = webAccesability.getText();
            assertEquals("WEB ACCESSIBILITY", webAccesabilityName);

        }
    }

