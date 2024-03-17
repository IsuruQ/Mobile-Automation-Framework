package org.example.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SignUpPage {
    private final By email = AppiumBy.accessibilityId("input-email");
    private final By password = AppiumBy.accessibilityId("input-password");
    private final By confirmPassword = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-repeat-password\"]");
    private final By SignUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final WebDriverWait wait;
    private final By PopUpMessage = AppiumBy.id("android:id/message");
    private final By PopupOkButton = AppiumBy.id("android:id/button1");

    public SignUpPage(final AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String dosignUp(final String Email, final String pass) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.email)).sendKeys(Email);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys(pass);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmPassword)).sendKeys(pass);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.SignUpButton)).click();
        String messageText = this.wait.until(visibilityOfElementLocated(this.PopUpMessage)).getText();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.PopupOkButton));
        return messageText;
    }
}
