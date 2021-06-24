package com.planit.sdet.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planit.sdet.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest{
    
    @Test

    public void validateProducts(){
        var products=open(HomePage.class)
        .clickProductMenu()
        .clickModelLevel1()
        .clickModelLevel2()
        .clickModelLevel3()
        .getProduct(p -> p.getProductTitle().equals("Kincrome 1,000kg Dual Stage Transmission Jack"));
       assertEquals(799, products.getProductPrice());

    }
}
