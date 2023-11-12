
package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

    public class Title {
        public static void task1(WebDriver driver) {

            driver.get("https://www.epam.com/");
            driver.manage().window().maximize();

            String pagetitle = driver.getTitle();

            assertEquals("EPAM | Software Engineering & Product Development Services", pagetitle);


        }
    }
