package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class SafariWebDriver {

    public static WebDriver loadSafariDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
