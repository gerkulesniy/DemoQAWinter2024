package org.winter2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBox {
    @Test
    void checkBox() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        WebElement homeOpen = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        homeOpen.click();

        WebElement desktopOpen = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        desktopOpen.click();

        WebElement notes = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label"));
        WebElement commands = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label"));
        notes.click();
        commands.click();

        List<WebElement> desktopList = driver.findElements(By.xpath("//div[@class='display-result mt-4']"));
        desktopList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

        System.out.println("\t+documents: ");

        WebElement documentsOpen = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        documentsOpen.click();

        WebElement workSpace = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/label"));
        workSpace.click();

        WebElement office = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label"));
        office.click();

        List<WebElement> withDocList = driver.findElements(By.xpath("//div[@class='display-result mt-4']"));
        withDocList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

        System.out.println("\t+downloads");

        WebElement downloadsOpen = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        downloadsOpen.click();

        WebElement wordFile = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label"));
        wordFile.click();

        WebElement excelFile = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label"));
        excelFile.click();

        List<WebElement> withDownList = driver.findElements(By.xpath("//div[@class='display-result mt-4']"));
        withDownList.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

    }
}
