package com.mailTravelIndia.pages;

import com.mailTravelIndia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DateDeparturePage {

    public DateDeparturePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='1. Date, Departure & Passengers']")
    public WebElement dateDeparturePassengers;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_bf_passenger_number unit size1of2 lastUnit']")
    public WebElement numberOfAdults;

    @FindBy(xpath = "//span[@dir='ltr']")
    public WebElement nameOfTheAirport;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_bf_departuredate']")
    public WebElement departureDate;

    @FindBy(id = "room-1673582-numselect")
    public WebElement numberOfRoom;

    @FindBy(xpath = "//*[.='Select your room and continue']")
    public WebElement selectYourRoomAndContinue;

    //---------------First Adult Locators----------------------

    @FindBy(id = "pax-a-title-1")
    public WebElement title;

    @FindBy(id = "pax-a-first-1")
    public WebElement firstName;

    @FindBy(id = "pax-a-last-1")
    public WebElement lastName;

    @FindBy(id = "pax-a-dobd-1")
    public WebElement day;

    @FindBy(id = "pax-a-dobm-1")
    public WebElement month;

    @FindBy(id = "pax-a-doby-1")
    public WebElement year;

    //---------------Second Adult Locators----------------------
    @FindBy(id = "pax-a-title-2")
    public WebElement title2;

    @FindBy(id = "pax-a-first-2")
    public WebElement firstName2;

    @FindBy(id = "pax-a-last-2")
    public WebElement lastName2;

    @FindBy(id = "pax-a-dobd-2")
    public WebElement day2;

    @FindBy(id = "pax-a-dobm-2")
    public WebElement month2;

    @FindBy(id = "pax-a-doby-2")
    public WebElement year2;

    //---------------Contact Details Locators----------------------

    @FindBy(id = "contact-mobile")
    public WebElement contactPhoneNumber;

    @FindBy(id = "contact-email")
    public WebElement contactEmail;

    @FindBy(id = "contact-address1")
    public WebElement addressLine1;

    @FindBy(id = "contact-address2")
    public WebElement addressLine2;

    @FindBy(id = "contact-city")
    public WebElement contactCity;

    @FindBy(id = "contact-postcode")
    public WebElement contactPostCode;

    @FindBy(id = "contact-country")
    public WebElement country;

    @FindBy(id = "contact-hearabout")
    public WebElement whereDidYouHearAboutUs;

    @FindBy(xpath = "//div[@class='nbf_fancy_paxButton nbf_fg_pms_button_text ']")
    public WebElement continueButton;






















}
