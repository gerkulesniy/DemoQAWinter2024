import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LomaemNambu {
    @Test
    void nambaFood() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/");

        WebElement foodBtn = driver.findElement(By.xpath("/html/body/main/section[3]/a/div/img"));
        foodBtn.click();

        WebElement nationalBtn = driver.findElement(By.xpath("/html/body/div[2]/main/section[3]/div/a[1]/div[1]/img"));
        nationalBtn.click();

        WebElement aliBtn = driver.findElement(By.xpath("//div[normalize-space(text()) = 'Кафе Alligator Green']"));
        aliBtn.click();

        WebElement shefSalat = driver.findElement(By.xpath("//*[@id=\"14\"]/div/div[2]/div[2]/button"));
        shefSalat.click();

        WebElement korzina = driver.findElement(By.id("cart"));
        korzina.click();

        WebElement oformitZakaz = driver.findElement(By.xpath("/html/body/main/section/div[1]/div[5]/div[11]/a/button"));
        oformitZakaz.click();

        WebElement fio = driver.findElement(By.id("food_order_client_name"));
        fio.sendKeys("Cristiano Ronaldo");

        WebElement address = driver.findElement(By.id("food_order_address"));
        address.sendKeys("Svetlaya Polyana");

        WebElement kvartira = driver.findElement(By.id("food_order_door_code"));
        kvartira.sendKeys("Svoya");

        WebElement telepon = driver.findElement(By.id("food_order_phone"));
        telepon.sendKeys("0777111717");

        WebElement dopInfo = driver.findElement(By.id("food_order_additional_info"));
        dopInfo.sendKeys("Eto Prank");

        WebElement sdacha = driver.findElement(By.id("food_order_money_change"));
        sdacha.sendKeys("1000");

        WebElement zakazat = dopInfo.findElement(By.xpath("/html/body/main/section/form/div[3]/div/div/div[1]/div/div[4]/button"));
        zakazat.click();

        driver.close();
        driver.quit();



    }
}