package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {



       System.setProperty("webdriver.chrome.driver", "C:\\JavaStudy\\chromedriver-win64 118\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Title.task1(driver);
        SwitchMode.task2(driver);
        ChangeLanguage.task3(driver);
        CheckPolicies.task4(driver);
        SwitchLocation.task5(driver);
        CheckSearch.task6(driver);
        FormFields.task7(driver);
        CompanyLogo.task8(driver);
        DownloadReport.task9(driver);

        driver.quit();

        System.setProperty("webdriver.gecko.driver", "C:\\JavaStudy\\FirefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        Title.task1(driver);
        SwitchMode.task2(driver);
        ChangeLanguage.task3(driver);
        CheckPolicies.task4(driver);
        SwitchLocation.task5(driver);
        CheckSearch.task6(driver);
        FormFields.task7(driver);
        CompanyLogo.task8(driver);
        DownloadReport.task9(driver);

        driver.quit();

    }
}
