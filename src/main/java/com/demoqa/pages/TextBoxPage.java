package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.TextBoxEntity;
import com.demoqa.helper.WebElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage {



    @FindBy(id = "userName")
    public WebElement fullNameInput;


    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public TextBoxPage fillUpTextBoxForm(String fullname, String email, String currAddress, String permAddress){
        webElementActions.sendKeys(fullNameInput,fullname)
                .sendKeys(emailInput,email)
                .sendKeys(currentAddressInput,currAddress)
                .sendKeys(permanentAddressInput,permAddress)
                .click(submitBtn);
        return this;
    }

    @Step("Fill up text box form")
    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.jsSendKeys(fullNameInput,textBoxEntity.getFullName())
                .jsSendKeys(emailInput, textBoxEntity.getEmail())
                .jsSendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                .jsSendKeys(permanentAddressInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
    }
}
