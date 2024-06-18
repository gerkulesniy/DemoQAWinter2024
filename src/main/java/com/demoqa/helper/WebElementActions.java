package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementActions {

    public Actions actions;

    public WebElementActions(){
        this.actions = new Actions(DriverManager.getDriver());
    }



    public WebElementActions click(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions print(WebElement element) {
        System.out.println(element.getText());
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        return this;
    }

    // МЕТОД необходимый для редактирования данных
    public WebElementActions clearAndSendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }


    public WebElementActions waitElementToBeClickAble(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    } // метод жаваскрипт который работает не через интерфес,а на прямую
    // с хтмл кода


    public WebElementActions highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", element, txt);
    return this;
    }

    public WebElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element){
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public void pause(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
