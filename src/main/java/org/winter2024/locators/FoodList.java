package org.winter2024.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FoodList {
    @Test
    void findFoodList(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/kukhnya-na-rayone");

        List<WebElement> foodList = driver.findElements(By.xpath("//div[@class='card--item-info']/div[2]"));

        for (WebElement food:foodList){
            System.out.println(food.getText());
        }
        System.out.println(foodList.size());

//        List<WebElement> muesliAndFruitsList = driver.findElements(By.xpath(""));
//        List<WebElement> croissants = driver.findElements(By.xpath(""));

        //div[@class='card--item--title pointer--title']
    }
}
