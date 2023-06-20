package com.SkyBet.pages;

import com.SkyBet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* I am creating POM to centralise my locators for easy access and maintainability
   I create constructor for the home page, use PageFactory class and use static initElements method
   which takes two parameters; the current instance of the driver and 'this' which refers to instance
   of the class
 */

public class SkyBetHomePage {

    public SkyBetHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesButton;

     @FindBy(css = ".js-login.js-login-analytics.header-bar__log-in")
     public WebElement loginButton;

}
