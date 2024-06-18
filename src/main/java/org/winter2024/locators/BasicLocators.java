package org.winter2024.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {

    @Test(description = "Find by id")
    void findByIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String name = "Adilet";
        String email = "derzko69@gmail.com";
        String currAdd = "Svetlaya Polyana";
        String perAdd = "Shas ya doma uje";

        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys(name);


        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailInput.sendKeys(email);

        WebElement currentAdress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        currentAdress.sendKeys(currAdd);

        WebElement permanentAdress = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        permanentAdress.sendKeys(perAdd);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String submitNameText = driver.findElement(By.xpath("//*[@id=\"name\"]")).getText();
        System.out.println(submitNameText);


        String submitEmailText = driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();
        System.out.println(submitEmailText);

        String submitCurAddText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
        System.out.println(submitCurAddText);

        String submitPerAddText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[4]")).getText();
        System.out.println(submitPerAddText);

        Thread.sleep(4000);

//        driver.close();
//        driver.quit();

        Assert.assertEquals("Name:" +name, submitNameText);
        Assert.assertEquals("Email:"+email, submitEmailText);
        Assert.assertEquals("Current Address :"+currAdd, submitCurAddText);
        Assert.assertEquals("Permananet Address :"+ perAdd,submitPerAddText);
    }

}
