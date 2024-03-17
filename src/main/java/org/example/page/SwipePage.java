package org.example.page;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class SwipePage {
    private final WebDriver driver;

    public SwipePage(WebDriver driver) {
        this.driver = driver;
    }

    public void swipeCarouselLeft() {
        RemoteWebElement carousel = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Carousel"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("gesture: swipe", ImmutableMap.of("elementId", carousel.getId(), "percentage", 90, "direction", "left"));
    }

    private boolean isCompatibleDisplayed() {
        WebElement textElement = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='slideTextContainer']/android.widget.TextView[1]"));
        return "COMPATIBLE".equals(textElement.getText());
    }

    public void swipeCarouselLeftUntilCompatible() {
        while (!isCompatibleDisplayed()) {
            swipeCarouselLeft();
        }

    }

}
