package com.planit.sdet.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignInMenu(){
       driver.findElement(By.id("icon-account")).click();
       return new SignInPage(driver);
    }
    public SignUp clickSignUpMenu(){
        driver.findElement(By.cssSelector("div:nth-child(5) > span > span > a")).click();
        return new SignUp(driver);
    }
}
