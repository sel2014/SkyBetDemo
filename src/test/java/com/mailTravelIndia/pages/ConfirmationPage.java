package com.mailTravelIndia.pages;

import com.mailTravelIndia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    public ConfirmationPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//h1)[2]")
    public WebElement confirmDetailAndBook;

    @FindBy(id = "nbf_booknow_button")
    public WebElement bookNow;
}
