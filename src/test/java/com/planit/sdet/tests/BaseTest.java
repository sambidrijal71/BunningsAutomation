package com.planit.sdet.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    
    protected WebDriver driver;

    @BeforeEach
    public void startUp(){
    this.driver = new FirefoxDriver();

        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get("https://www.bunnings.com.au");
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

