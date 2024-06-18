package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxWebDriver {

    public static WebDriver loadFirefoxDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
