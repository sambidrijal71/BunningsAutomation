package com.planit.sdet.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends BasePage{

    public SignUp(WebDriver driver) {
        super(driver);

    }
    public SignUp setFirstName(String firstName){
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        return this;
    }
    public SignUp setLastName(String lastName){
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        return this;
    }
    public SignUp setEmail(String firstName){
        driver.findElement(By.id("uid")).sendKeys(firstName);;
        return this;
    }
    public SignUp setPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);;
        return this;
    }
    public SignUp clickCheckBox(){
        driver.findElement(By.id("communicationPrefFlag")).click();
        return this;
    }
    public SignUp clickCreateAccount(){
        driver.findElement(By.cssSelector("div:nth-child(8) > button > span")).click();
        return this;
    }


    public String firstNameError(){
        return getErrorMessages(By.id("firstName-error-message-text"));        
    }
    public String lastNameError(){
        return getErrorMessages(By.id("lastName-error-message-text"));       
    }
    public String emailError(){
        return getErrorMessages(By.id("uid-error-message-text"));        
    }
    public String passwordError(){
        return getErrorMessages(By.id("password-error-message-text"));    
    }
    public String passwordHelper(){
        return getErrorMessages(By.id("password-helper-group"));    
    }


    private String getErrorMessages(By locator){
        var errorMessage=driver.findElements(locator);
        if(errorMessage.isEmpty())
            return "";
        return errorMessage.get(0).getText();
    }
    
}
