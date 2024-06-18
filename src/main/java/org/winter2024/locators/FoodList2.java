package org.winter2024.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FoodList2 {
    @Test
    void findFoodList(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg");

        WebElement foodBtn = driver.findElement(By.xpath("/html/body/main/section[3]/a"));
        foodBtn.click();

        WebElement euroBtn = driver.findElement(By.xpath("//div[normalize-space(text())='Европейская кухня']/following-sibling::div[1]"));
        euroBtn.click();

        WebElement paulBtn = driver.findElement(By.xpath("//div[normalize-space(text())='PAUL']"));

        List<WebElement> euroCafeList = driver.findElements(By.xpath("//div[@class='cafe--name']"));
        euroCafeList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.err.println("Кол-во кафешек: " + euroCafeList.size());


        if (euroCafeList.contains(paulBtn)){
            paulBtn.click();
        } else { driver.quit();
        driver.close(); }

        System.out.println("_____________________________");
        System.out.println("Мюсли и фрукты:");
       List<WebElement> muesliAndFruitsList = driver.findElements(By.xpath("/html/body/main/section[2]/div[1]/span[1]/div"));
       muesliAndFruitsList.stream()
               .map(WebElement::getText)
               .forEach(System.out::println);

        System.out.println("_____________________________");
        System.out.println("Круассаны:");
        List<WebElement> kruasanList = driver.findElements(By.xpath("/html/body/main/section[2]/div[1]/span[2]/div"));
        kruasanList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

        System.out.println("_____________________________");
        System.out.println("Напитки:");
        List<WebElement> napitkiList = driver.findElements(By.xpath("/html/body/main/section[2]/div[1]/span[15]/div"));
        napitkiList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);


    }
}
