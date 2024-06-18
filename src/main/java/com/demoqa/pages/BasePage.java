package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.DropdownHelper;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends DemoQAPages {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElementActions webElementActions = new WebElementActions();

    public DropdownHelper dropdownHelper = new DropdownHelper(DriverManager.getDriver());

}
