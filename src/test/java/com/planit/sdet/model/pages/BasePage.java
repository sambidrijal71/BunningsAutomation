package com.planit.sdet.model.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage{
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public SignInPage clickSignInMenu(){
       driver.findElement(By.id("icon-account")).click();
       return new SignInPage(driver);

    }
    public SignUpPage clickSignUpMenu(){
        driver.findElement(By.cssSelector("div:nth-child(5) > span > span > a")).click();
        return new SignUpPage(driver);
    }
    public ProductPage clickProductMenu(){
        driver.findElement(By.id("navContainer")).click();
         return new ProductPage(driver);
    }
    public CartPage clickCartMenu(){
        driver.findElement(By.id("icon-cart")).click();
        return new CartPage(driver);
    }
    public int getCartCount() {
        return Integer.parseInt(driver.findElement(By.className("cartItemCount")).getText());
    }


    public ProductPage clickSearchBar(){
        driver.findElement(By.id("custom-css-outlined-input")).click();
       return new ProductPage(driver);
     }


     public ProductPage SetValuesInSearchBar(String SearchValue){
        driver.findElement(By.className("MuiInputBase-input")).sendKeys(SearchValue);
       return new ProductPage(driver);
     }

    public ProductPage clickSearchButton(){
        driver.findElement(By.className("search-icon-wrapper")).click();
       return new ProductPage(driver);
     }

     public ProductPage clickSearchButtonn(){
        driver.findElement(By.id("crossIcon")).click();
       return new ProductPage(driver);
     }
    
}
