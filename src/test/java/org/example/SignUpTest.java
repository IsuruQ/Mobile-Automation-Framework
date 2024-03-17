package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.page.LandingPage;
import org.example.page.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class SignUpTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        final UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(Path.of(System.getProperty("user.dir"), "src/test/resources/demo.apk").toString())
                .setDeviceName("Android")
                .setAppWaitActivity("com.wdiodemoapp.MainActivity")
                .setCapability("appium:settings[ignoreUnimportantViews]", true);
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void teardownclass() {
        this.driver.quit();
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
