package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.utils.RandomUtils;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder

public class DemoQAPages {


    public TextBoxPage textBoxPage;
    public PracticeFormPage practiceFormPage;
    public CheckBoxPage checkBoxPage;

    public AlertPage alertPage;

    public ButtonsPage buttonsPage;
    public MenuPage menuPage;
    public ProgressBarPage progressBarPage;
    public WebTablePage webTablePage;



    public void setUp(){

        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
        checkBoxPage = new CheckBoxPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        webTablePage = new WebTablePage();
    }
}
