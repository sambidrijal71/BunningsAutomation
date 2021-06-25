package com.planit.sdet.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planit.sdet.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class SignInTest extends BaseTest{

    @Test
    public void validateErrorMessage(){
        var errorMessage=open(HomePage.class)
        .clickSignInMenu()
        .clickSignInButtonMain()
        .clickSignInButton();
        var error=errorMessage.getErrorMessage();
        var emailError=errorMessage.getEmailError();
        var passwordError=errorMessage.getPasswordError();
        assertEquals("Please correct the highlighted errors", error);
        assertEquals("This field is required", emailError);
        assertEquals("This field is required", passwordError);
    }

    /*@Test
    public void validateUser(){
    var signIn=open(HomePage.class)
        .clickCartMenu()
        .clickSignInMenu()
        .clickSignInButtonMain()
        .setEmail("samboharama@gmail.com")
        .setpassword("Ball-Apple1")
        .checkBox()
        .clickSignInButton();
    }*/

    @Test
    public void validateUserError(){
        var errorMessage=open(HomePage.class)
        .clickSignInMenu()
        .clickSignInButtonMain()
        .clickSignInButton()
        .setEmail("sam@b.com")
        .setpassword("apple");
        var error=errorMessage.getErrorMessage();
        var emailError=errorMessage.getEmailError();
        var passwordError=errorMessage.getPasswordError();
        assertEquals("Please correct the highlighted errors", error);
        assertEquals("", emailError);
        assertEquals("", passwordError);

    }
}
