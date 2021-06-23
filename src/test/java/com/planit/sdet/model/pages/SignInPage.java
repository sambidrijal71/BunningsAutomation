package com.planit.sdet.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);

    }
    public SignInPage clickSignInButtonMain(){
        driver.findElement(By.className("MyAccountToolbarstyle__StyledLoginButton-sc-1535o7y-1")).click();
        return this;
    }

    public SignInPage setEmail(String email){
        driver.findElement(By.id("okta-signin-username")).sendKeys(email);;
        return this;
    }

    public SignInPage setpassword(String password){
        driver.findElement(By.id("okta-signin-password")).sendKeys(password);;
        return this;
    }

    public SignInPage checkBox(){
        driver.findElement(By.id("input41")).click();
        return this;
    }

    public SignInPage clickSignInButton(){
        driver.findElement(By.id("okta-signin-submit")).click();
        return this;
    }

    public String getErrorMessage(){
        return getErrorMessages(By.className("o-form-has-errors"));
    }
    public String getEmailError(){
        return getErrorMessages(By.id("input-container-error53"));
    }
    public String getPasswordError(){
        return getErrorMessages(By.id("input-container-error54"));
    }

    private String getErrorMessages(By locator){
        var errorMessage=driver.findElements(locator);
        if(errorMessage.isEmpty())
            return "";
        return errorMessage.get(0).getText();
    }
}
