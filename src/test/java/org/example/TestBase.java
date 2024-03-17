package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class TestBase {

    protected AndroidDriver driver;

    public void setupDriver() throws MalformedURLException {
        final UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(Path.of(System.getProperty("user.dir"), "src/test/resources/demo.apk").toString())
                .setDeviceName("Android")
                .setAppWaitActivity("com.wdiodemoapp.MainActivity")
                .setCapability("appium:settings[ignoreUnimportantViews]", true);
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
