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
        driver.findElement(By.cssSelector("li:nth-child(2) > a > span.text")).click();
        return this;
    }
    public ProductPage clickModelLevel2(){
        driver.findElement(By.cssSelector("li.active > ul > div > li:nth-child(3) > a > span.text")).click();
        return this;
    }
    public ProductPage clickModelLevel3(){

        driver.findElement(By.cssSelector("li.active > ul > div > li.active > ul > div > li:nth-child(3) > a > span.text")).click();
        return this;
    }

    public ProductPage clickSearchBar(){
        driver.findElement(By.id("custom-css-outlined-input")).click();
       return this;
     }


     public ProductPage SetValuesInSearchBar(String SearchValue){
        driver.findElement(By.className("MuiInputBase-input")).sendKeys(SearchValue);
       return this;
     }

    public ProductPage clickSearchButton(){
        driver.findElement(By.className("search-icon-wrapper")).click();
       return this;
     }

     public ProductPage clickSearchButtonn(){
        driver.findElement(By.id("crossIcon")).click();
       return this;
     }

     public String verifySearchResult(){

        var elem = driver.findElement(By.className("searchTerm"));
        return elem.findElement(By.cssSelector("h2 > span")).getText();
      
     }
    

     public String verifyPopularSearchDialog(){
        return this.driver.findElement(By.className("iPwNXt")).getText();
        
     }

    public Product getProduct(Function<Product, Boolean> strategy) {
        var elements = new WebDriverWait(driver, 30).until(d -> d.findElements(By.className("search-product-tile")));
        return elements.stream()
            .map(e -> new Product(e, this))
            .filter(p -> strategy.apply(p))
            .findFirst()
            .orElseThrow();
    }


}
