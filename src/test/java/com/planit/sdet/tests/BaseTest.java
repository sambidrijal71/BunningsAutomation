package com.planit.sdet.tests;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    public WebDriver driver;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void startUp() {
        String url = "https://www.bunnings.com.au";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        // options.addArguments("--disable-geolocation");
        Map < String, Object > prefs = new HashMap < String, Object > ();
        Map < String, Object > profile = new HashMap < String, Object > ();
        Map < String, Object > contentSettings = new HashMap < String, Object > ();
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
    prefs.put("profile", profile);
    options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterEach
    public void shutdown() {
        this.driver.quit();
    }

    public <T> T open(Class<T> clazz) {
        try {
            return clazz.getConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
