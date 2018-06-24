package appium.travelex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static appium.utils.AppiumSetup.getDriver;

class TravelexPage {

    void scrollToSlider() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(slider());
        actions.perform();
    }

    void swipeToSecondTab() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(secondTab());
        actions.perform();
    }

    void swipeToThirdTab() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(thirdTab());
        actions.perform();
    }

    void clickOnCrossIconCookiesMessage() {
        if (cookiesMessageAcceptIcon().isDisplayed()) {
            cookiesMessageAcceptIcon().click();
        }
    }

    void checkBuyButtonIsDisplayed() {
        buyButton().isDisplayed();
    }

//        void swipeLeftOnSlider() {
//        TouchAction swipe = new TouchAction(getDriver()).press(firstBaner())
//                .waitAction(2000).moveTo(secondBaner()).release();
//        swipe.perform();
//    }

    private WebElement cookiesMessageAcceptIcon() {
        return getDriver().findElement(By.id("_ghostery-accept-button"));
    }

    private WebElement slider() {
        return getDriver().findElement(By.xpath("//div[@class='sliderdb slick-slide slick-active']//div[@class='four-col db simpleBlock']//div[@class='box-cont matchHeight']"));
    }

    private WebElement secondTab() {
        return getDriver().findElement(By.xpath("//a[@href='https://wire.travelex.co.uk?utm_source=travelex&utm_medium=referral'][contains(text(),'International money transfer')]"));
    }

    private WebElement thirdTab() {
        return getDriver().findElement(By.xpath("//a[@href='/currency'][contains(text(),'Buy foreign currency')]"));
    }

    private WebElement buyButton() {
        return getDriver().findElement(By.xpath("//div[@class='box-cont matchHeight']//a[@href='/currency']"));
    }
}
