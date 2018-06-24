package appium.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static appium.utils.AppiumSetup.getDriver;

class WikipediaMainPage {

    void inputText(String inputText) {
        searchField().sendKeys(inputText);
    }

    void clickOnSearchButton() {
        searchButton().click();
    }

    String siteTitle() {
        return getDriver().getTitle();
    }

    private WebElement searchField() {
        return getDriver().findElement(By.id("searchInput"));
    }

    private WebElement searchButton() {
        return getDriver().findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']"));
    }
}
