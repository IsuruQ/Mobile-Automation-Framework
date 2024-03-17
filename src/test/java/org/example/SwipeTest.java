package org.example;

import org.example.page.LandingPage;
import org.example.page.SwipePage;
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

    @Test
    public void testSwipe() {
        final var landingpage = new LandingPage(this.driver);
        final var swipepage = new SwipePage(this.driver);
        landingpage.navigateToSwipe();
        swipepage.swipeCarouselLeftUntilCompatible();

    }
}
