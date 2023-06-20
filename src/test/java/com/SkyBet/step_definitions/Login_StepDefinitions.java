package com.SkyBet.step_definitions;

import com.SkyBet.pages.SkyBetHomePage;
import com.SkyBet.pages.SkyBetLoginPage;
import com.SkyBet.utilities.BrowserUtils;
import com.SkyBet.utilities.ConfigurationReader;
import com.SkyBet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;

public class Login_StepDefinitions {

    SkyBetHomePage skyBetHomePage = new SkyBetHomePage();
    SkyBetLoginPage skyBetLoginPage = new SkyBetLoginPage();



    String skyBetAccountFrameID = "SkyBetAccount";

    @Given("I am on the SkyBet website")
    public void iAmOnTheSkyBetWebsite() {

        Driver.getDriver().get(ConfigurationReader.getProperty("skyBetUrl"));
        BrowserUtils.waitFor(1);
        skyBetHomePage.cookiesButton.click();

    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {

        BrowserUtils.waitFor(1);
        skyBetHomePage.loginButton.click();
    }

    @And("I enter valid credentials")
    public void iEnterValidCredentials() {


        Driver.getDriver().switchTo().frame(skyBetAccountFrameID);

        skyBetLoginPage.userName.click();
        skyBetLoginPage.userName.sendKeys("sel2014");
        skyBetLoginPage.pinNumber.click();
        skyBetLoginPage.pinNumber.sendKeys("163253");

        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        BrowserUtils.waitFor(1);



   }
    @And("I click on the second Log in button")
    public void iClickOnTheSecondLogInButton() {

        skyBetLoginPage.loginButton2.click();

        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        BrowserUtils.waitFor(1);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String string) {
        BrowserUtils.verifyTitle(string);
        System.out.println(Driver.getDriver().getTitle());


    }


}
