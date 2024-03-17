package org.example.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private final By LoginBtn = AppiumBy.accessibilityId("Login");
    private final By SwipeBtn = AppiumBy.accessibilityId("Swipe");
    private final By SignUpTab = AppiumBy.accessibilityId("button-sign-up-container");
    private final WebDriverWait wait;

    public LandingPage(final AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToSignUp() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.LoginBtn)).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.SignUpTab)).click();
    }

    public void navigateToSwipe() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.SwipeBtn)).click();
    }
}
