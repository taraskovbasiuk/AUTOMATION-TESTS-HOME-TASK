package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

///needs upd
public class DownloadReport {


    public static void task9(WebDriver driver) {

        driver.get("https://www.epam.com/about");
        driver.manage().window().maximize();

        //accept cookies
        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //scroll to the download button
        WebElement downloadButton = driver.findElement(By.xpath(("(//a[@class=\"button-ui-23 btn-focusable\"])[1]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", downloadButton);

        downloadButton.click();


        // wait for the file to download
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // set the path to the downloads folder
        String downloadsPath = System.getProperty("user.home") + "\\Downloads\\";

        // create a File object for the downloads folder
        File downloadsFolder = new File(downloadsPath);

        // get the list of files in the downloads folder
        File[] files = downloadsFolder.listFiles();

        // loop through the files and check the name of each one
        boolean fileFound = false;
        for (File file : files) {
            String fileName = file.getName();
            System.out.println(fileName);
            if (fileName.startsWith("EPAM_Corporate_Overview") && fileName.endsWith(".pdf")) {

                fileFound = true;
                break;
            }
        }

        // check if the file was found
        Assert.assertTrue(fileFound);
        driver.quit();

    }
}
