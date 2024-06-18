package org.winter2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LomaemGlovo {
    @Test
    void gloveLoxi(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://glovoapp.com/kg/ru/bishkek/");



    }
}
