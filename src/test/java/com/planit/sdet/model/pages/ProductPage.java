package com.planit.sdet.model.pages;

import com.google.common.base.Function;
import com.planit.sdet.model.shop.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    
    public ProductPage clickModelLevel1(){
        new WebDriverWait(driver,30).until(d->d.findElement(By.cssSelector("li:nth-child(2) > a > span.text"))).click();
        return this;
    }
    public ProductPage clickModelLevel2(){
        new WebDriverWait(driver,30).until(d->d.findElement(By.cssSelector("li.active > ul > div > li:nth-child(3) > a > span.text"))).click();
        return this;
    }
    public ProductPage clickModelLevel3(){
        new WebDriverWait(driver,30).until(d->d.findElement(By.cssSelector(" li.active > ul > div > li.active > ul > div > li:nth-child(3) > a > span.text"))).click();
        return this;
    }
    public Product getProduct(Function<Product, Boolean> strategy) {
        var elements = new WebDriverWait(driver,30).until(d->d.findElements(By.className("search-product-tile")));
        return elements.stream()
            .map(e -> new Product(e, this))
            .filter(p -> strategy.apply(p))
            .findFirst()
            .orElseThrow();
    }

}
