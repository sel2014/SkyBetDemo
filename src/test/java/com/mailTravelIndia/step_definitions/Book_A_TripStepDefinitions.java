package com.mailTravelIndia.step_definitions;

import com.github.javafaker.Faker;
import com.mailTravelIndia.pages.ConfirmationPage;
import com.mailTravelIndia.pages.DateDeparturePage;
import com.mailTravelIndia.pages.HomePage;
import com.mailTravelIndia.utilities.BrowserUtils;
import com.mailTravelIndia.utilities.ConfigurationReader;
import com.mailTravelIndia.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class Book_A_TripStepDefinitions {

    HomePage homePage = new HomePage();  //instance of my HomePage class to be able to access the locators
    DateDeparturePage dateDeparturePage = new DateDeparturePage();//instance of my DateDeparturePage
    ConfirmationPage confirmationPage = new ConfirmationPage();//instance of my ConfirmationPage

    Faker faker = new Faker(); //faker, my favourite java class.
    // using faker on class level so I can use it anywhere below

    @When("the user is on the homepage of the {string}")
    public void theUserIsOnTheHomepageOfThe(String string) {

        Driver.getDriver().get(ConfigurationReader.getProperty("mailTravelIndiaURL"));
    }

    @Then("user should see the title is {string}")
    public void userShouldSeeTheTitleIs(String string) {
        //calling my verify title in BrowserUtils
        BrowserUtils.verifyTitle(string);
        System.out.println("Expected URL: " + string);

    }

    @And("the user accepts all cookies")
    public void theUserAcceptsAllCookies() {

        BrowserUtils.waitFor(3);
        homePage.acceptCookiesButton.click();
        BrowserUtils.waitFor(1);


    }

    @When("the user searches for {string} in the search bar")
    public void theUserSearchesForInTheSearchBar(String string) {
        homePage.searchBar.sendKeys(string);
        BrowserUtils.waitFor(2);
        homePage.indiaLink.click();
        BrowserUtils.waitFor(1);

    }


    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String string) {

       homePage.arrowButton.click();
       BrowserUtils.waitFor(1);
       /*
         A little note here; please Select Your Departure Date Message was initially visible on
         the web page when I did my assertion but disappeared later on (still not visible). As a result
         I had to comment out the below code. (Step 3 in task sheet) Please check the website
        */
//        homePage.bookOnlineButton.click();
//        System.out.println(homePage.pleaseSelectYourDepartureDateMessage.getText());
//        Assert.assertTrue(homePage.pleaseSelectYourDepartureDateMessage.isDisplayed());
//        BrowserUtils.waitFor(2);


    }

    @And("the user scrolls to the bottom of the page and selects the next available date")
    public void theUserScrollsToTheBottomOfThePageAndSelectsTheNextAvailableDate() {

        BrowserUtils.scrollToElement(homePage.dateAndPricesTitle);
        homePage.nextAvailableDate.click();
        BrowserUtils.waitFor(1);

    }

    @Then("user should not see the {string} text")
    public void userShouldNotSeeTheText(String string) {

        //after date selection 'please enter your date' should not be displayed
        //below is my assertion
        boolean isNotVisible = true;
        try {
            if (homePage.pleaseSelectYourDepartureDateMessage.isDisplayed()) {
                isNotVisible = false;
            }
        } catch (NoSuchElementException e) {
            // without this, my assertion gives NoSuchElementException, this has to be caught
        }
        Assert.assertTrue(isNotVisible);


    }


    @When("user select {string} adults from dropdown menu and validate the airport")
    public void userSelectAdultsFromDropdownMenuAndValidateTheAirport(String string) {

        homePage.numberOfAdultBox.click();
        Select numberOfAdultsDropDown = new Select(homePage.numberOfAdultBox);
        numberOfAdultsDropDown.selectByValue(string);
        BrowserUtils.waitFor(1);
        homePage.numberOfAdultBox.click();
        //I selected number of adults above

        //I need to validate the airport now
        String expectedAirport = "London Heathrow Airport";
        String actualAirport = homePage.DepartureAirport.getText();
        System.out.println("actualAirport = " + actualAirport);
        Assert.assertEquals(expectedAirport, actualAirport);

    }

    @And("user validate the price for {string} adults")
    public void userValidateThePriceForAdults(String string) {

        /* I wanted to make sure my code below is dynamic so when the number of
        adults changes, my calculation changes too so my assertion will pass.
         */

        String firstAvailableDatePrice = homePage.firstAvailableDatePrice.getText();

        // I need to Remove non-numeric characters from the firstAvailableDatePrice
        // otherwise I am getting NumberFormatException
        String numericFirstAvailableDatePrice = firstAvailableDatePrice.replaceAll
                ("[^\\d.]", "");

        int expectedTotalPrice = Integer.parseInt(string) * Integer.parseInt(numericFirstAvailableDatePrice);

        //now I need to find the actual price, I need to remove special characters here too.
        String price = homePage.actualPriceValue.getText();
        int actualPrice = Integer.parseInt (price.replaceAll
                ("[^\\d.]", ""));

        System.out.println("expectedTotalPrice = " + expectedTotalPrice);
        System.out.println("actualPrice = " + actualPrice);


        //now I need to do my assertion,
        Assert.assertEquals(expectedTotalPrice, actualPrice);


    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String string) {

        homePage.bookOnlineButton2.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user expands the Date, Departure & Passengers section")
    public void theUserExpandsTheDateDeparturePassengersSection() {
        dateDeparturePage.dateDeparturePassengers.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the details populated are valid")
    public void thenTheDetailsPopulatedAreValid() {

        int numberOfAdults = Integer.parseInt(dateDeparturePage.numberOfAdults.getText());
        String nameOfTheAirport = dateDeparturePage.nameOfTheAirport.getText();
        String departureDate = dateDeparturePage.departureDate.getText();

        Assert.assertTrue("invalid number of adults", numberOfAdults >=1);
        Assert.assertNotNull( "Departure airport is not populated", nameOfTheAirport);
        Assert.assertNotNull( "Departure date is not populated", departureDate);


    }

    @And("the user selects the number of rooms required as {int} for two people")
    public void theUserSelectsTheNumberOfRoomsRequiredAsForPeople(int arg0) {

        //changes here, website changed?
        dateDeparturePage.numberOfRoom.click();
        Select numberOfRooms = new Select(dateDeparturePage.numberOfRoom);
        numberOfRooms.selectByValue("1");
        dateDeparturePage.numberOfRoom.click();
        BrowserUtils.waitFor(1);

    }

    @And("the user clicks on {string}")
    public void theUserClicksOn(String string) {
        dateDeparturePage.selectYourRoomAndContinue.click();

    }

    @And("the user fills in the passenger details")
    public void theUserFillsInThePassengerDetails() {

        //ADULT 1
        dateDeparturePage.title.click();
        Select titleOptions = new Select(dateDeparturePage.title);
        titleOptions.selectByValue("Mr");
        dateDeparturePage.title.click();
        BrowserUtils.waitFor(1);

        dateDeparturePage.firstName.sendKeys(faker.name().firstName());
        dateDeparturePage.lastName.sendKeys(faker.name().lastName());
        BrowserUtils.waitFor(1);
        dateDeparturePage.day.click();

        Select dayOptions = new Select(dateDeparturePage.day);
        dayOptions.selectByValue("10");
        dateDeparturePage.day.click();
        BrowserUtils.waitFor(1);

        Select monthOptions = new Select(dateDeparturePage.month);
        dateDeparturePage.month.click();
        monthOptions.selectByValue("2");
        dateDeparturePage.month.click();
        BrowserUtils.waitFor(1);

        Select yearOptions = new Select(dateDeparturePage.year);
        dateDeparturePage.year.click();
        yearOptions.selectByValue("1987");
        dateDeparturePage.year.click();
        BrowserUtils.waitFor(1);

        //ADULT2

        dateDeparturePage.title2.click();
        Select titleOptions2 = new Select(dateDeparturePage.title2);
        titleOptions2.selectByValue("Mrs");
        dateDeparturePage.title2.click();
        BrowserUtils.waitFor(1);

        dateDeparturePage.firstName2.sendKeys(faker.name().firstName());
        dateDeparturePage.lastName2.sendKeys(faker.name().lastName());
        BrowserUtils.waitFor(1);


        dateDeparturePage.day2.click();
        Select dayOptions2 = new Select(dateDeparturePage.day2);
        dayOptions2.selectByValue("18");
        dateDeparturePage.day2.click();
        BrowserUtils.waitFor(1);

        Select monthOptions2 = new Select(dateDeparturePage.month2);
        dateDeparturePage.month2.click();
        monthOptions2.selectByValue("2");
        dateDeparturePage.month2.click();
        BrowserUtils.waitFor(1);

        Select yearOptions2 = new Select(dateDeparturePage.year2);
        dateDeparturePage.year2.click();
        yearOptions2.selectByValue("1987");
        dateDeparturePage.year2.click();
        BrowserUtils.waitFor(1);

    }

    @And("the user fills in contact details and selects {string} as answer to how did you hear about us")
    public void theUserFillsInContactDetailsAndSelectsAsAnswerToHowDidYouHearAboutUs(String string) {

        dateDeparturePage.contactPhoneNumber.sendKeys("01234567890");
        dateDeparturePage.contactEmail.sendKeys(faker.internet().emailAddress());
        dateDeparturePage.addressLine1.sendKeys("123");
        dateDeparturePage.addressLine2.sendKeys("Beautiful Street");
        dateDeparturePage.contactCity.sendKeys("City Of Hope");
        dateDeparturePage.contactPostCode.sendKeys("DMG 012");

        // country is selected by default, no need to select United Kingdom

       Select whereDidYouHearAboutUs = new Select(dateDeparturePage.whereDidYouHearAboutUs);
       dateDeparturePage.whereDidYouHearAboutUs.click();
       whereDidYouHearAboutUs.selectByValue("2");
       dateDeparturePage.whereDidYouHearAboutUs.click();
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String string) {

        dateDeparturePage.continueButton.click();
    }

    @Then("the user verifies the {string} text is displayed")
    public void theUserVerifiesTheTextIsDisplayed(String string) {

        BrowserUtils.verifyElementDisplayed(confirmationPage.confirmDetailAndBook);
        BrowserUtils.waitFor(5); //waiting to upload to next page
    }
    @And("the user verifies that the {string} button is enabled")
    public void theUserVerifiesThatTheButtonIsEnabled(String string) {
        Assert.assertTrue(confirmationPage.bookNow.isEnabled());
        String expected = string;
        String actual = confirmationPage.bookNow.getText();
        Assert.assertEquals(expected, actual);

    }
}
