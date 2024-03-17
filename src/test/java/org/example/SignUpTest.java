package org.example;

import org.example.page.LandingPage;
import org.example.page.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpTest extends TestBase {

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        setupDriver();
    }

    @AfterClass
    public void teardownclass() {
        teardownDriver();
    }

    @Test
    public void testSignUp() {
        final var signUpPage = new SignUpPage(this.driver);
        final var landingpage = new LandingPage(this.driver);
        landingpage.navigateToSignUp();
        var actualMessage = signUpPage.dosignUp("pgiakalanka@gmail.com", "1998+Isuru");
        Assert.assertEquals(actualMessage, "You successfully signed up!");
    }
}
