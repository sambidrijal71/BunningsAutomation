package com.planit.sdet.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planit.sdet.model.pages.HomePage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CartTest extends BaseTest{
    @Test

    public void validateProductName() throws InterruptedException{
        var products = open(HomePage.class)
        .clickProductMenu()
        .clickModelLevel1()
        .clickModelLevel2()
        .clickModelLevel3()
        .getProduct(p -> p.getProductTitle().equals("Kincrome 1,000kg Dual Stage Transmission Jack"))
        .clickAddToCart();

        /*var test =new HomePage(driver);
        driver.findElement(By.id("navContainer")).click();
        driver.findElement(By.cssSelector("li:nth-child(2) > a > span.text")).click();
        driver.findElement(By.cssSelector("li.active > ul > div > li:nth-child(3) > a > span.text")).click();
        driver.findElement(By.cssSelector("li.active > ul > div > li.active > ul > div > li:nth-child(3) > a > span.text")).click();
        driver.findElement(By.cssSelector("article[data-code='0275525']"));*/





    }
}
