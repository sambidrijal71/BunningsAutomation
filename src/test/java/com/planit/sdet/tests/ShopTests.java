package com.planit.sdet.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planit.sdet.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class ShopTests extends BaseTest{
    
    @Test
    public void validateEmptySearchBar()
    {
         var searchElement = open(HomePage.class)
         .clickSearchButton();
         var popularSearch = searchElement.verifyPopularSearchDialog();
         assertEquals("Popular searches",popularSearch);
    }



    @Test
    public void validateBuyProductThroughSearchBar()
    {
        var productname = "50mm Plastic Brick Ties Bag of 100";
         var searchproduct = open(HomePage.class)
         .clickSearchBar()
         .SetValuesInSearchBar(productname)
         .clickSearchButtonn()
         .getProduct(p -> p.getProductTitle().equals(productname));
       assertEquals(64, searchproduct.getProductPrice());  
    }

    @Test
    public void validatecheckoutProductThroughSearchbar()
    {
        var productname = "50mm Plastic Brick Ties Bag of 100";
         var searchproduct = open(HomePage.class)
         .clickSearchBar()
         .SetValuesInSearchBar(productname)
         .clickSearchButtonn()
         .getProduct(p -> p.getProductTitle().equals(productname))
         .clickAddToCart();
         
    }
}
