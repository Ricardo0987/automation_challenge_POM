package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyCustomDriver implements DriverSource {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    @Override
    public WebDriver newDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "/home/ricardo/IdeaProjects/automation_challenge/src/test/resources/apk/PreciseUnitConversion.apk");
        String url = "http://0.0.0.0:4723/wd/hub";


        AppiumDriver<MobileElement> appDriver = null;
        try {

            appDriver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
            Thread.sleep(2500);
            appDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException | InterruptedException e) {
            e.printStackTrace();
        }
        appDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver = appDriver;
        return appDriver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
