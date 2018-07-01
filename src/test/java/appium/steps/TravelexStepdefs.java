package appium.steps;

import appium.travelex.TravelexPage;
import appium.utils.AppiumSetup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TravelexStepdefs extends AppiumSetup {

    TravelexPage travelexPage = new TravelexPage();

    @Given("^User launches travelex website$")
    public void userLaunchesTravelexWebsite() throws Throwable {
        setCapabilities();
        getDriver().get("https://travelex.co.uk");
    }


    @And("^User dismisses cookies message$")
    public void userDismissesCookiesMessage() throws Throwable {
        travelexPage.clickOnCrossIconCookiesMessage();
    }


    @When("^User scrolls to banner$")
    public void userScrollsToBanner() throws Throwable {
        travelexPage.scrollToSlider();
    }


    @Then("^User can swipe to third banner$")
    public void userCanSwipeToThirdBanner() throws Throwable {
        travelexPage.checkBuyButtonIsDisplayed();
    }
}
