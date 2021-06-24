package com.planit.sdet.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage getCartProductName(){
        driver.findElement(By.className("productItemName")).getText();
        return this;
    }

    public CartPage getCartItemPrice(){
        driver.findElement(By.className("productItemPrice")).getText();
        return this;
    }
}
