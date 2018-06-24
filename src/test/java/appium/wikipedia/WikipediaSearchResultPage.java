package appium.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static appium.utils.AppiumSetup.getDriver;

class WikipediaSearchResultPage {

    void clickOnSuggestionMessage() {
        suggestionMessage().click();
    }

    int numberOfSearchResults() {
        List<WebElement> searchResults = searchResultsBlock().findElements(By.className("searchresult"));
        return searchResults.size();
    }

    void clickOnArtilceWithTitle(String title) {
        articleTitle(title).click();
    }

    WebElement suggestionMessage() {
        return getDriver().findElement(By.xpath("//div[@class='searchdidyoumean']"));
    }

    private WebElement searchResultsBlock() {
        return getDriver().findElement(By.xpath("//ul[@class='mw-search-results']"));
    }

    private WebElement articleTitle(String title) {
        return getDriver().findElement(By.xpath(title));
    }
}
