package com.mailTravelIndia.pages;

import com.mailTravelIndia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* I am creating POM to centralise my locators for easy access and maintainability
   I create constructor for the home page, use PageFactory class and use static initElements method
   which takes two parameters; the current instance of the driver and 'this' which refers to instance
   of the class
 */

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

   @FindBy(id = "searchtext_freetext_search_form")
    public WebElement searchBar;

    @FindBy(xpath = "//a[@name='1']")
    public WebElement indiaLink;

    @FindBy(xpath = "//*[@id=\"nbf_tpl_pms_calendar-f0050aa159413059b0d39248658bdb50\"]/div/div[3]")
    public WebElement arrowButton;

    @FindBy(css = ".nbf_button.nbf_tpl_pms_book_button")
    public WebElement bookOnlineButton;

    @FindBy(xpath = "(//*[.='Please select your departure date'])[2]")
    public WebElement pleaseSelectYourDepartureDateMessage;

    @FindBy(id = "dates_and_prices_title")
    public WebElement dateAndPricesTitle;


    @FindBy(id = "calbox-f0050aa159413059b0d39248658bdb50-1")
    public WebElement nextAvailableDate;

    @FindBy(xpath = "//*[@id=\"departure-selection\"]/div/span")
    public WebElement DepartureAirport;

    @FindBy(id = "numAdults-f0050aa159413059b0d39248658bdb50")
    public WebElement numberOfAdultBox;

    @FindBy(xpath = "//*[@id=\"tour-price\"]/span")
    public WebElement priceForTheTrip;

    @FindBy(xpath = "(//span[@class='ibecurr'])[2]")
    public WebElement firstAvailableDatePrice;

    @FindBy(id = "tour-price")
    public WebElement actualPriceValue;

    @FindBy(xpath = "(//*[.='Book Online'])[2]")
    public WebElement bookOnlineButton2;
}
