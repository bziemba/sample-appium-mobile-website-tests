package appium.wikipedia;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static appium.utils.AppiumSetup.getDriver;

class WikipediaArticlePage {

    void checkArticleTitleIsDisplayed() {
        articleTitle().isDisplayed();
    }

    void checkTableOfContentsIsDisplayed() {
        tableOfContents().isDisplayed();
    }

    void checkTableOfContentIsNotDisplayed() {
        By tableOfContent = By.xpath("//div[@class='toc-mobile view-border-box']");
        Boolean notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(tableOfContent)).apply(getDriver());
        Assert.assertEquals(true, notPresent);
    }

    String getArticleTitle() {
        return articleTitle().getText();
    }

    private WebElement articleTitle() {
        return getDriver().findElement(By.id("section_0"));
    }

    private WebElement tableOfContents() {
        return getDriver().findElement(By.xpath("//div[@class='toc-mobile view-border-box']"));
    }
}
