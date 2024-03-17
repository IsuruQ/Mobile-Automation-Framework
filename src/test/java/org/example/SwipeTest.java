package org.example;

import org.example.page.LandingPage;
import org.example.page.SwipePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SwipeTest extends TestBase {
    @BeforeClass
    public void setupClass() throws MalformedURLException {
        setupDriver();
    }

    @AfterClass
    public void teardownclass() {
        teardownDriver();
    }

    @Test(priority = 1)
    public void testSwipeLeft() {
        final var landingpage = new LandingPage(this.driver);
        final var swipepage = new SwipePage(this.driver);
        landingpage.navigateToSwipe();
        swipepage.swipeCarouselLeftUntilCompatible();
    }

    @Test(priority = 2)
    public void testSwipeUp() {
        final var landingpage = new LandingPage(this.driver);
        final var swipepage = new SwipePage(this.driver);
        landingpage.navigateToSwipe();
        WebElement webIoLogo = swipepage.swipeUp();
        Assert.assertTrue(webIoLogo.isDisplayed(), "WebIO logo is visible after swiping up.");

    }

}
