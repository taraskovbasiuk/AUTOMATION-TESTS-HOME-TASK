
package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

    public class Title {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.epam.com/");

            String pagetitle = driver.getTitle();

            assertEquals("EPAM | Software Engineering & Product Development Services", pagetitle);

        }
    }
