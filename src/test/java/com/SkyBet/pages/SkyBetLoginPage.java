package com.SkyBet.pages;

import com.SkyBet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkyBetLoginPage {

    public SkyBetLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "pin")
    public WebElement pinNumber;

    @FindBy(id = "login-submit")
    public WebElement loginButton2;


    @FindBy(css = ".quick-link.left")
    public WebElement logOutButton;




}
