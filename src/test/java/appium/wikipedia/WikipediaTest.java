package appium.wikipedia;

import appium.utils.AppiumSetup;
import org.junit.*;

import java.io.InterruptedIOException;
import java.net.MalformedURLException;

public class WikipediaTest extends AppiumSetup {

    private WikipediaMainPage wikipediaMainScreen = new WikipediaMainPage();
    private WikipediaSearchResultPage wikipediaSearchResultPage = new WikipediaSearchResultPage();
    private WikipediaArticlePage wikipediaArticlePage = new WikipediaArticlePage();

    @Before
    public void setUp() throws MalformedURLException, InterruptedIOException {
        setCapabilities();
        getDriver().get("https://www.wikipedia.org/");
    }

    //This test fails because title of the wikipedia.org site is "Wikipedia" not "wikipedia"
    // as it has been written in the assignment description
    @Test
    @Ignore
    public void checkSiteTitle() {
        Assert.assertEquals("wikipedia", wikipediaMainScreen.siteTitle());
    }

    @Test
    public void checkSiteTitleIsCorrect() {
        Assert.assertEquals("Wikipedia", wikipediaMainScreen.siteTitle());
    }

    @Test
    public void checkSuggestionIsDisplayedAfterSearch() {
        wikipediaMainScreen.inputText("furry rabbits");
        wikipediaMainScreen.clickOnSearchButton();
        wikipediaSearchResultPage.suggestionMessage().isDisplayed();
    }

    @Test
    public void check20SearchResultsDisplayedAfterTappingOnSuggestion() {
        wikipediaMainScreen.inputText("furry rabbits");
        wikipediaMainScreen.clickOnSearchButton();
        wikipediaSearchResultPage.clickOnSuggestionMessage();
        Assert.assertEquals(20, wikipediaSearchResultPage.numberOfSearchResults());
    }

    @Test
    public void checkArticleContainsTitle() {
        wikipediaMainScreen.inputText("furry rabbits");
        wikipediaMainScreen.clickOnSearchButton();
        wikipediaSearchResultPage.clickOnSuggestionMessage();
        wikipediaSearchResultPage.clickOnArtilceWithTitle("//a[@href='/wiki/Watership_Down']");
        wikipediaArticlePage.checkArticleTitleIsDisplayed();
        Assert.assertEquals("Watership Down", wikipediaArticlePage.getArticleTitle());
    }

    //This test fails as in mobile website table of contents in not displayed.
    @Test
    @Ignore
    public void checkArticleContainsTableOfContents() {
        wikipediaMainScreen.inputText("furry rabbits");
        wikipediaMainScreen.clickOnSearchButton();
        wikipediaSearchResultPage.clickOnSuggestionMessage();
        wikipediaSearchResultPage.clickOnArtilceWithTitle("//a[@href='/wiki/Watership_Down']");
        wikipediaArticlePage.checkTableOfContentsIsDisplayed();
    }

    @Test
    public void checkArticleDoesNotContainTableOfContents() {
        wikipediaMainScreen.inputText("furry rabbits");
        wikipediaMainScreen.clickOnSearchButton();
        wikipediaSearchResultPage.clickOnSuggestionMessage();
        wikipediaSearchResultPage.clickOnArtilceWithTitle("//a[@href='/wiki/Watership_Down']");
        wikipediaArticlePage.checkTableOfContentIsNotDisplayed();
    }
}
