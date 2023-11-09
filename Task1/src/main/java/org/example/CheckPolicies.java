
package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class CheckPolicies {

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.epam.com/");
            driver.manage().window().maximize();

            //accept the cookey
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();

            //scroll to locations

            WebElement regions = driver.findElement(By.className("tabs-ui-23"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", regions);



            WebElement regionsAmericas = driver.findElement(By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[1]/a"));
            String SectionAmericas = regionsAmericas.getText();
            assertEquals("AMERICAS", SectionAmericas);

            WebElement regionsEMEA = driver.findElement(By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[2]/a"));
            String SectionEMEA = regionsEMEA.getText();
            assertEquals("EMEA", SectionEMEA);

            WebElement regionsAPAC = driver.findElement(By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[3]/a"));
            String SectionAPAC = regionsAPAC.getText();
            assertEquals("APAC", SectionAPAC);

            //select regions under locations
            driver.findElement(By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[2]/div/div/div[1]/div[1]/div/div[6]/div/button")).click();

            WebElement ColombiaLocations = driver.findElement(By.xpath("(//*[@class=\"locations-viewer-23__country-counter body-text-small\"])[1]"));
            String ColumbLocTxt = ColombiaLocations.getText();
            Assert.assertEquals(ColumbLocTxt, "2 locations");



        /*WebElement investors = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[1]/li[1]/a"));
        String investorsName = investors.getText();
        assertEquals("INVESTORS", investorsName);

        WebElement openSorce = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[1]/li[2]/a"));
        String openSorceName = openSorce.getText();
        assertEquals("OPEN SOURCE", openSorceName);

        WebElement privacyPolicy = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[1]/li[3]/a"));
        String privacyPolicyName = privacyPolicy.getText();
        assertEquals("PRIVACY POLICY", privacyPolicyName);

        WebElement cookiePolicy = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[2]/li[1]/a"));
        String cookiePolicyName = cookiePolicy.getText();
        assertEquals("COOKIE POLICY", cookiePolicyName);

        WebElement applicantPrivacyNotoce = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[2]/li[2]/a"));
        String applicantPrivacyNotoceName = applicantPrivacyNotoce.getText();
        assertEquals("APPLICANT PRIVACY NOTICE", applicantPrivacyNotoceName);

        WebElement webAccesability = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[1]/footer/div/div/div[1]/div[2]/div/ul[2]/li[3]/a"));
        String webAccesabilityName = webAccesability.getText();
        assertEquals("WEB ACCESSIBILITY", webAccesabilityName);*/


        /*Actions actions = new Actions(driver);
        actions.moveToElement(policies);*/

        /*WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("location-selector__button"))).click();

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a")).click();


        WebElement htmlTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));

        //WebElement htmlTag = driver.findElement(By.tagName("html"));

        String lang = htmlTag.getAttribute("lang");

        sleep(2000);

       Assert.assertEquals(lang, "uk-UA");*/


        }
    }

