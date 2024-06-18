package com.demoqa.pages;

import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    @FindBy(id = "confirmButton")
    public WebElement confirmAlertBtn;


}
