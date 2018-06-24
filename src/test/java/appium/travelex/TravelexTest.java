package appium.travelex;

import appium.utils.AppiumSetup;
import org.junit.Before;
import org.junit.Test;

import java.io.InterruptedIOException;
import java.net.MalformedURLException;

public class TravelexTest extends AppiumSetup {

    private TravelexPage travelexPage = new TravelexPage();

    @Before
    public void setUp() throws MalformedURLException, InterruptedIOException {
        setCapabilities();
        getDriver().get("https://travelex.co.uk");
    }

    @Test
    public void checkThirdBanerIsDisplaydAfterScrolling() throws InterruptedException {
        travelexPage.clickOnCrossIconCookiesMessage();
        travelexPage.scrollToSlider();
        travelexPage.swipeToSecondTab();
        travelexPage.swipeToThirdTab();
        travelexPage.checkBuyButtonIsDisplayed();
    }
}
