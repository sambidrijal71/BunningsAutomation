package com.planit.sdet.model.shop;

import com.planit.sdet.model.pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
    private WebElement rootElement;
    private ProductPage parent;

    public Product(WebElement rootElement, ProductPage parent) {
        this.rootElement = rootElement;
        this.parent = parent;
    }
    public String getProductTitle() {
        return this.rootElement.findElement(By.className("product-title")).getText();
    }

    public int getProductPrice() {
        return Integer.parseInt(this.rootElement.findElement(By.className("search-price")).getText().replace("$", ""));
    }
    public Product clickAddToCart() {
        this.rootElement.findElement(By.className("MuiButton-textSecondary")).click();
        return this;
    }
    public ProductPage page() {
        return parent;
    }
}
